package com.highthunder.kotlr.response.type.blog

import com.highthunder.kotlr.json.response.blog.BlogInfoWrapperJsonAdapter
import com.highthunder.kotlr.response.ResponseMetaInfo
import com.highthunder.kotlr.response.TumblrError
import com.highthunder.kotlr.response.TumblrResponse
import com.highthunder.kotlr.response.WrapperInterface
import com.highthunder.kotlr.types.Blog
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * ResponseBlogInfo - TODO: Documentation
 *
 * @author highthunder
 * @since 11/4/18
 * @version 1.0.0
 */
interface ResponseBlogInfo {
    /**
     * TODO: Documentation
     *
     * @param meta TODO: Documentation
     * @param response TODO: Documentation
     * @param errors TODO: Documentation
     */
    @JsonClass(generateAdapter = true)
    data class Response constructor(
        @Json(name = "meta")
        override val meta: ResponseMetaInfo,
        @Json(name = "response")
        override val response: WrapperInterface<Body>,
        @Json(name = "errors")
        override val errors: List<TumblrError>? = null
    ) : TumblrResponse<Body>

    /**
     * Adapter is [BlogInfoWrapperJsonAdapter].
     *
     * @param body The body of this response.
     * @param error The error message if there is no body.
     */
    data class Wrapper constructor(
        override val error: String? = null,
        override val body: Body? = null
    ) : WrapperInterface<Body>

    /**
     * TODO: Documentation
     *
     * @param blog TODO: Documentation
     */
    @JsonClass(generateAdapter = true)
    data class Body constructor(
        @Json(name = "blog")
        val blog: Blog? = null
    )
}
