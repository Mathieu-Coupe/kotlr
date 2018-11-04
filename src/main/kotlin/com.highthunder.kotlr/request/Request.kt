package com.highthunder.kotlr.request

import com.github.scribejava.core.model.Verb
import com.highthunder.kotlr.response.Response
import kotlin.reflect.KClass

/**
 * Request - A generic request to the Tumblr API.
 *
 * Each type of request to the Tumblr API implements this interface.
 *
 * TODO: Expand to support multipart form uploads.
 *
 * @author highthunder
 * @since 10/23/18
 * @version 1.0.0
 */
interface Request<out T> {
    fun getBaseUrl(): String
    fun getUrlParameters(apiKey: String): String
    fun getUrl(apiKey: String): String {
        val params = getUrlParameters(apiKey)
        return "${getBaseUrl()}${if (params.isNotBlank()) "?$params" else ""}"
    }
    val responseClass: KClass<out Response<out T>>
    val verb: Verb
    val requiresOAuth: Boolean
    val improvedByOAuth: Boolean
}