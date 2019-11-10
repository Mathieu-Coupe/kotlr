package com.highthunder.kotlr

import com.highthunder.kotlr.authentication.TumblrAppKey
import com.highthunder.kotlr.authentication.TumblrUserKey
import com.highthunder.kotlr.json.qualifier.HexColorJsonAdapter
import com.highthunder.kotlr.json.qualifier.HexColorOctothorpeJsonAdapter
import com.highthunder.kotlr.json.superwrapper.AttributionAmalgamationAdapter
import com.highthunder.kotlr.json.superwrapper.BlockLayoutAmalgamationAdapter
import com.highthunder.kotlr.json.superwrapper.ContentAmalgamationAdapter
import com.highthunder.kotlr.json.superwrapper.DisplayModeAmalgamationAdapter
import com.highthunder.kotlr.json.superwrapper.NoteDataAmalgamationAdapter
import com.highthunder.kotlr.json.superwrapper.PostAmalgamationAdapter
import com.highthunder.kotlr.json.superwrapper.TextFormatAmalgamationAdapter
import com.squareup.moshi.Moshi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer
import se.akerfeldt.okhttp.signpost.OkHttpOAuthProvider
import se.akerfeldt.okhttp.signpost.SigningInterceptor

/**
 * Get an instance of the Moshi JSON parser that is setup to parse all of our data types.
 *
 * This is broken up into four steps because some adapters depend on the existence of
 * other adapters.
 */
internal val moshi: Moshi by lazy {
    return@lazy Moshi
        .Builder()
        .add(ContentAmalgamationAdapter())
        .add(AttributionAmalgamationAdapter())
        .add(TextFormatAmalgamationAdapter())
        .add(BlockLayoutAmalgamationAdapter())
        .add(DisplayModeAmalgamationAdapter())
        .add(NoteDataAmalgamationAdapter())
        .add(HexColorJsonAdapter())
        .add(HexColorOctothorpeJsonAdapter())
        .add(PostAmalgamationAdapter())
        .add(KotlrJsonAdapterFactory())
        .build()
}

private const val API_BASE_URL = "https://api.tumblr.com/v2/"
private const val O_AUTH_BASE_URL = "https://www.tumblr.com/oauth/"
private const val AUTHORIZE_URL = "${O_AUTH_BASE_URL}authorize"
private const val REQUEST_TOKEN_RESOURCE = "${O_AUTH_BASE_URL}request_token"
private const val ACCESS_TOKEN_RESOURCE = "${O_AUTH_BASE_URL}access_token"

private val allow300ResponseInterceptor: Interceptor = Interceptor { chain: Interceptor.Chain ->
    val response = chain.proceed(chain.request())
    return@Interceptor if (response.code in 300 until 400) {
        response
            .newBuilder()
            .code(200)
            .build()
    } else {
        response
    }
}

internal fun getOAuthConsumer(appKey: TumblrAppKey): OkHttpOAuthConsumer =
    OkHttpOAuthConsumer(appKey.apiKey, appKey.apiSecret)

private fun getOAuthConsumer(userKey: TumblrUserKey): OkHttpOAuthConsumer =
    OkHttpOAuthConsumer(userKey.apiKey, userKey.apiSecret).also {
        it.setTokenWithSecret(userKey.userKey, userKey.userSecret)
    }

internal fun getOAuthProvider(okHttpOAuthConsumer: OkHttpOAuthConsumer): OkHttpOAuthProvider =
    OkHttpOAuthProvider(
        REQUEST_TOKEN_RESOURCE,
        ACCESS_TOKEN_RESOURCE,
        AUTHORIZE_URL,
        getHttpClient(okHttpOAuthConsumer)
    )

private fun getHttpClient(consumer: OkHttpOAuthConsumer, debug: Boolean = false): OkHttpClient {
    val logging = HttpLoggingInterceptor().apply {
        level = if (debug) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
    }

    val httpClient = OkHttpClient.Builder()
    httpClient.followRedirects(false)
    httpClient.retryOnConnectionFailure(false)

    httpClient.addInterceptor(SigningInterceptor(consumer))
    httpClient.addInterceptor(allow300ResponseInterceptor)
    httpClient.addNetworkInterceptor(logging)

    return httpClient.build()
}

private fun getClient(consumer: OkHttpOAuthConsumer, debug: Boolean = false): Retrofit {
    var moshiFactory = MoshiConverterFactory.create(moshi)
    if (debug) {
        moshiFactory = moshiFactory.failOnUnknown()
    }

    return Retrofit.Builder()
        .baseUrl(API_BASE_URL)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(moshiFactory)
        .client(getHttpClient(consumer, debug))
        .build()
}

fun getApi(userKey: TumblrUserKey, debug: Boolean = false): KotlrApi =
    getClient(getOAuthConsumer(userKey), debug).create()
