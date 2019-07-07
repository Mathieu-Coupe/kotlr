package com.highthunder.kotlr.types

import com.highthunder.kotlr.types.content.TextFormat
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * NoteData - TODO: Documentation
 *
 * @author highthunder
 * @since 11/3/18
 * @version 1.0.0
 */
sealed class NoteData {
    @Json(name = "type")
    abstract var type: String?
    @Json(name = "timestamp")
    abstract var timestamp: Long?
    @Json(name = "blog_name")
    abstract var blogName: String?
    @Json(name = "blog_uuid")
    abstract var blogUuid: String?
    @Json(name = "blog_url")
    abstract var blogUrl: String?
    @Json(name = "followed")
    abstract var blogFollowed: Boolean?
    @Json(name = "avatar_shape")
    abstract var avatarShape: String?

    /**
     * TODO: Documentation
     */
    @JsonClass(generateAdapter = true)
    class Like constructor(
        @Json(name = "timestamp")
        override var timestamp: Long? = null,
        @Json(name = "blog_name")
        override var blogName: String? = null,
        @Json(name = "blog_uuid")
        override var blogUuid: String? = null,
        @Json(name = "blog_url")
        override var blogUrl: String? = null,
        @Json(name = "followed")
        override var blogFollowed: Boolean? = null,
        @Json(name = "avatar_shape")
        override var avatarShape: String? = null
    ) : NoteData() {
        companion object {
            const val KEY: String = "like"
        }

        @Json(name = "type")
        override var type: String? = KEY
    }

    /**
     * TODO: Documentation
     */
    @JsonClass(generateAdapter = true)
    class Posted constructor(
        @Json(name = "timestamp")
        override var timestamp: Long? = null,
        @Json(name = "blog_name")
        override var blogName: String? = null,
        @Json(name = "blog_uuid")
        override var blogUuid: String? = null,
        @Json(name = "blog_url")
        override var blogUrl: String? = null,
        @Json(name = "followed")
        override var blogFollowed: Boolean? = null,
        @Json(name = "avatar_shape")
        override var avatarShape: String? = null
    ) : NoteData() {
        companion object {
            const val KEY: String = "posted"
        }

        @Json(name = "type")
        override var type: String? = KEY
    }

    /**
     * TODO: Documentation
     *
     * @param postId TODO: Documentation
     * @param reblogParentBlogName TODO: Documentation
     */
    @JsonClass(generateAdapter = true)
    class Reblog constructor(
        @Json(name = "timestamp")
        override var timestamp: Long? = null,
        @Json(name = "blog_name")
        override var blogName: String? = null,
        @Json(name = "blog_uuid")
        override var blogUuid: String? = null,
        @Json(name = "blog_url")
        override var blogUrl: String? = null,
        @Json(name = "followed")
        override var blogFollowed: Boolean? = null,
        @Json(name = "avatar_shape")
        override var avatarShape: String? = null,
        @Json(name = "post_id")
        var postId: String? = null,
        @Json(name = "added_text")
        var addedText: String? = null,
        @Json(name = "reblog_parent_blog_name")
        var reblogParentBlogName: String? = null,
        @Json(name = "can_block")
        var canBlock: Boolean? = null
    ) : NoteData() {
        companion object {
            const val KEY: String = "reblog"
        }

        @Json(name = "type")
        override var type: String? = KEY
    }

    /**
     * TODO: Documentation
     *
     * @param replyText TODO: Documentation
     * @param formatting TODO: Documentation
     * @param canBlock TODO: Documentation
     */
    @JsonClass(generateAdapter = true)
    class Reply constructor(
        @Json(name = "timestamp")
        override var timestamp: Long? = null,
        @Json(name = "blog_name")
        override var blogName: String? = null,
        @Json(name = "blog_uuid")
        override var blogUuid: String? = null,
        @Json(name = "blog_url")
        override var blogUrl: String? = null,
        @Json(name = "followed")
        override var blogFollowed: Boolean? = null,
        @Json(name = "avatar_shape")
        override var avatarShape: String? = null,
        @Json(name = "reply_text")
        var replyText: String? = null,
        @Json(name = "formatting")
        var formatting: List<TextFormat>? = null,
        @Json(name = "can_block")
        var canBlock: Boolean? = null
    ) : NoteData() {
        companion object {
            const val KEY: String = "reply"
        }

        @Json(name = "type")
        override var type: String? = KEY
    }

    /**
     * TODO: Documentation
     *
     * @param postAttributionType TODO: Documentation
     * @param postAttributionTypeName TODO: Documentation
     * @param photoUrl TODO: Documentation
     * @param photoWidth TODO: Documentation
     * @param photoHeight TODO: Documentation
     */
    @JsonClass(generateAdapter = true)
    class Attribution constructor(
        @Json(name = "timestamp")
        override var timestamp: Long? = null,
        @Json(name = "blog_name")
        override var blogName: String? = null,
        @Json(name = "blog_uuid")
        override var blogUuid: String? = null,
        @Json(name = "blog_url")
        override var blogUrl: String? = null,
        @Json(name = "followed")
        override var blogFollowed: Boolean? = null,
        @Json(name = "avatar_shape")
        override var avatarShape: String? = null,
        @Json(name = "post_id")
        var postId: String? = null,
        @Json(name = "post_attribution_type")
        var postAttributionType: String? = null,
        @Json(name = "post_attribution_type_name")
        var postAttributionTypeName: String? = null,
        @Json(name = "photo_url")
        var photoUrl: String? = null,
        @Json(name = "photo_width")
        var photoWidth: Int? = null,
        @Json(name = "photo_height")
        var photoHeight: Int? = null
    ) : NoteData() {
        companion object {
            const val KEY: String = "post_attribution"
        }

        @Json(name = "type")
        override var type: String? = KEY
    }
}
