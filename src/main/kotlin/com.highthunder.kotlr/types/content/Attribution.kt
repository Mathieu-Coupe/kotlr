package com.highthunder.kotlr.types.content

import com.highthunder.kotlr.types.Blog
import com.highthunder.kotlr.types.Media
import com.highthunder.kotlr.types.PostId

/**
 * Attribution - Content blocks and layout blocks can have an attribution object containing a
 * [PostAttribution], [LinkAttribution], [BlogAttribution], or [AppAttribution] type attribution. Like most objects in NPF,
 * attributions only require the type field, and other fields are required based on the given type.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
sealed class Attribution

/**
 * Post Attribution
 *
 * @param url The URL of the Post to be attributed.
 * @param post A Post object with at least an id field.
 * @param blog A Tumblelog object with at least a uuid field.
 */
data class PostAttribution constructor(
    val url: String? = null,
    val post: PostId? = null,
    val blog: Blog? = null
) : Attribution() {
    companion object {
        const val KEY: String = "post"
    }
}

/**
 * Link Attribution
 *
 * @param url The URL to be attributed for the content.
 */
data class LinkAttribution constructor(
    val url: String? = null
) : Attribution() {
    companion object {
        const val KEY: String = "link"
    }
}

/**
 * Blog Attribution
 *
 * @param blog A Tumblelog object with at least a uuid field.
 */
data class BlogAttribution constructor(
    val blog: Blog? = null
) : Attribution() {
    companion object {
        const val KEY: String = "blog"
    }
}

/**
 * App Attribution
 *
 * @param url The canonical URL to the source content in the third-party app.
 * @param appName The name of the application to be attributed.
 * @param displayText Any display text that the client should use with the attribution.
 * @param logo A specific logo Media Object that the client should use with the third-party app attribution.
 */
data class AppAttribution constructor(
    val url: String? = null,
    val appName: String? = null,
    val displayText: String? = null,
    val logo: Media? = null
) : Attribution() {
    companion object {
        const val KEY: String = "app"
    }
}
