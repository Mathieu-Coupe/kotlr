package com.highthunder.kotlr.request.type.blog

import com.github.scribejava.core.model.Verb
import com.highthunder.kotlr.request.Request
import com.highthunder.kotlr.response.ResponseInterface
import com.highthunder.kotlr.response.type.blog.ResponseBlogAvatar
import com.highthunder.kotlr.response.type.blog.ResponseBlogInfo
import kotlin.reflect.KClass

/**
 * RequestBlogInfo - TODO: Documentation
 *
 * @author highthunder
 * @since 11/4/18
 * @version 1.0.0
 */
class RequestBlogInfo(
    private val identifier: String
) : Request<ResponseBlogInfo.Body> {

    companion object {
        const val BASE_PATH = "blog/"
    }

    override val responseClass: KClass<out ResponseInterface<ResponseBlogInfo.Body>> = ResponseBlogInfo.Response::class
    override val verb: Verb = Verb.GET
    override val requiresOAuth: Boolean = false
    override val improvedByOAuth: Boolean = true

    override fun getBaseUrl(): String = "$apiRootPath$BASE_PATH$identifier/info"

    override fun getUrlParameters(apiKey: String): String {
        return StringBuilder().apply {
            apiKey.also {
                append("?")
                append("api_key=")
                append(it)
            }
        }.toString()
    }

}