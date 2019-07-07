package com.highthunder.kotlr.types.content

import com.highthunder.kotlr.types.Media
import com.highthunder.kotlr.types.PostId
import com.highthunder.kotlr.types.content.Attribution.App
import com.highthunder.kotlr.types.content.Attribution.Blog
import com.highthunder.kotlr.types.content.Attribution.Link
import com.highthunder.kotlr.types.content.Attribution.Post
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.highthunder.kotlr.types.Blog as RealBlog

/**
 * Attribution - Content blocks and layout blocks can have an attribution object containing a
 * [Link], [Blog], [Post], or [App] type attribution. Like most objects in NPF,
 * attributions only require the type field, and other fields are required based on the given type.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
sealed class Attribution {
    abstract var type: String?

    /**
     * Post Attribution
     *
     * @param url The URL of the Post to be attributed.
     * @param post A Post object with at least an id field.
     * @param blog A Tumblelog object with at least a uuid field.
     */
    @JsonClass(generateAdapter = true)
    class Post constructor(
        @Json(name = "url")
        var url: String? = null,
        @Json(name = "post")
        var post: PostId? = null,
        @Json(name = "blog")
        var blog: RealBlog? = null
    ) : Attribution() {
        companion object {
            const val KEY: String = "post"
        }

        override var type: String? = KEY
    }

    /**
     * Link Attribution
     *
     * @param url The URL to be attributed for the content.
     */
    @JsonClass(generateAdapter = true)
    class Link constructor(
        @Json(name = "url")
        var url: String? = null
    ) : Attribution() {
        companion object {
            const val KEY: String = "link"
        }

        override var type: String? = KEY
    }

    /**
     * Blog Attribution
     *
     * @param blog A Tumblelog object with at least a uuid field.
     */
    @JsonClass(generateAdapter = true)
    class Blog constructor(
        @Json(name = "blog")
        var blog: RealBlog? = null
    ) : Attribution() {
        companion object {
            const val KEY: String = "blog"
        }

        override var type: String? = KEY
    }

    /**
     * App Attribution
     *
     * @param url The canonical URL to the source content in the third-party app.
     * @param appName The name of the application to be attributed.
     * @param displayText Any display text that the client should use with the attribution.
     * @param logo A specific logo Media Object that the client should use with the third-party app attribution.
     */
    @JsonClass(generateAdapter = true)
    class App constructor(
        @Json(name = "url")
        var url: String? = null,
        @Json(name = "app_name")
        var appName: String? = null,
        @Json(name = "display_text")
        var displayText: String? = null,
        @Json(name = "logo")
        var logo: Media? = null
    ) : Attribution() {
        companion object {
            const val KEY: String = "app"
        }

        override var type: String? = KEY
    }
}
