package com.highthunder.kotlr.types

import com.highthunder.kotlr.types.content.BlockLayout
import com.highthunder.kotlr.types.content.PostContent
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Post - The base information about a post.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
interface Post {

    // region Defaults

    /**
     * The short name used to uniquely identify a blog.
     */
    val blogName: String?
    /**
     * The post's unique ID.
     */
    val id: Long?
    /**
     * A standard API-formatted "short blog info" object.
     */
    val blog: Blog?
    /**
     * The location of the post.
     */
    val postUrl: String?
    /**
     * The time of the post, in seconds since the epoch.
     */
    val timestamp: Long?
    /**
     * The GMT date and time of the post, as a string.
     */
    val date: String?
    /**
     * The post format: html, raw, or markdown.
     */
    val format: PostFormat?
    /**
     * The key used to reblog this post.
     */
    val reblogKey: String?
    /**
     * Tags applied to the post.
     */
    val tags: List<String>?
    /**
     * Indicates whether the post was created via the Tumblr bookmarklet.
     */
    val isBookmarklet: Boolean?
    /**
     * Indicates whether the post was created via mobile/email publishing.
     */
    val isMobile: Boolean?
    /**
     * The URL for the source of the content (for quotes, reblogs, etc.).
     */
    val sourceUrl: String?
    /**
     * The title of the source site.
     */
    val sourceTitle: String?
    /**
     * Indicates if a user has already liked a post or not.
     */
    val isLiked: Boolean?
    /**
     * Indicates the current state of the post.
     */
    val state: State?
    /**
     * The total number of post available for this request, useful for paginating through results.
     */
    val totalPosts: Int?
    /**
     * TODO: Documentation
     */
    val anonymous: Boolean?

    // endregion

    // region Situational Fields

    /**
     * The array of content that constitutes the body of a post in the Neue Post Format(NPF).
     */
    val content: List<PostContent>?
    /**
     * The previous Posts in the reblog trail. In order of oldest (the root Post) to the newest (the parent Post).
     */
    val trail: List<Trail>?
    /**
     * The layouts of the blocks in this post.
     */
    val layout: List<BlockLayout>?
    /**
     * The id of the author of the post.
     */
    val postAuthor: String?
    /**
     * The short URL for this post.
     */
    val shortUrl: String?
    /**
     * A short description of this post.
     */
    val summary: String?
    /**
     * Indicates whether or not this post is using the new block format(NPF).
     */
    val isBlocksFormat: Boolean?
    /**
     * The timestamp of when this post was liked.
     */
    val likedTimestamp: Long?
    /**
     * The slug. TODO: Documentation
     */
    val slug: String?
    /**
     * The note count for this post.
     */
    val noteCount: Long?
    /**
     * The source of a recommended post.
     */
    val recommendedSource: String?
    /**
     * The recommended color for styling this post.
     */
    val recommendedColor: String?
    /**
     * Indicates whether or not the author of this post is an adult only blog.
     */
    val postAuthorIsAdult: Boolean?
    /**
     * Indicates whether or not this post is a submission.
     */
    val isSubmission: Boolean?
    /**
     * Indicates whether or not the current user can like this post.
     */
    val canLike: Boolean?
    /**
     * Indicates whether or not the current user can reblog this post.
     */
    val canReblog: Boolean?
    /**
     * Indicates whether or not this post can be sent in a message.
     */
    val canSendInMessage: Boolean?
    /**
     * Indicates whether or not the current user can reply to this post.
     */
    val canReply: Boolean?
    /**
     * Indicates whether or not the poster's avatar should be shown with this post.
     */
    val displayAvatar: Boolean?
    /**
     * Indicates whether or not the current user follows the author of this post.
     */
    val followed: Boolean?
    /**
     * TODO: Documentation
     */
    val reblogData: ReblogData?
    /**
     * TODO: Documentation
     */
    val rebloggedFromId: Long?
    /**
     * TODO: Documentation
     */
    val rebloggedFromUrl: String?
    /**
     * TODO: Documentation
     */
    val rebloggedFromName: String?
    /**
     * TODO: Documentation
     */
    val rebloggedFromTitle: String?
    /**
     * TODO: Documentation
     */
    val rebloggedFromUuid: String?
    /**
     * TODO: Documentation
     */
    val rebloggedFromCanMessage: Boolean?
    /**
     * TODO: Documentation
     */
    val rebloggedFromFollowing: Boolean?
    /**
     * TODO: Documentation
     */
    val rebloggedRootId: Long?
    /**
     * TODO: Documentation
     */
    val rebloggedRootUrl: String?
    /**
     * TODO: Documentation
     */
    val rebloggedRootName: String?
    /**
     * TODO: Documentation
     */
    val rebloggedRootTitle: String?
    /**
     * TODO: Documentation
     */
    val rebloggedRootUuid: String?
    /**
     * TODO: Documentation
     */
    val rebloggedRootCanMessage: Boolean?
    /**
     * TODO: Documentation
     */
    val rebloggedRootFollowing: Boolean?
    /**
     * TODO: Documentation
     */
    val notes: List<NoteData>?
    /**
     * TODO: Documentation
     */
    val publishTime: Long?
    /**
     * TODO: Documentation
     */
    val queueState: QueueState?
    /**
     * TODO: Documentation
     */
    val shouldOpenInLegacy: Boolean?
    /**
     * TODO: Documentation
     */
    val muted: Boolean?
    /**
     * TODO: Documentation
     */
    val objectType: String?
    /**
     * TODO: Documentation
     */
    val type: Post.Type?
    /**
     * TODO: Documentation
     */
    val blogUUID: String?
    /**
     * TODO: Documentation
     */
    val parentPostId: Long?
    /**
     * TODO: Documentation
     */
    val parentBlogUUID: String?

    // endregion

    /**
     * Enum of valid post states.
     */
    @JsonClass(generateAdapter = false)
    enum class State {
        /**
         * TODO: Documentation
         */
        @Json(name = "draft")
        Draft,
        /**
         * TODO: Documentation
         */
        @Json(name = "queued")
        Queue,
        /**
         * TODO: Documentation
         */
        @Json(name = "published")
        Published,
        /**
         * TODO: Documentation
         */
        @Json(name = "private")
        Private,
        /**
         * TODO: Documentation
         */
        @Json(name = "submission")
        Submission
    }

    /**
     * Enum of valid post types.
     * @param key TODO: Documentation
     */
    @JsonClass(generateAdapter = false)
    enum class Type(val key: String) {
        /**
         * TODO: Documentation
         */
        @Json(name = "answer")
        Answer("answer"),
        /**
         * TODO: Documentation
         */
        @Json(name = "audio")
        Audio("audio"),
        /**
         * TODO: Documentation
         */
        @Json(name = "chat")
        Chat("chat"),
        /**
         * TODO: Documentation
         */
        @Json(name = "link")
        Link("link"),
        /**
         * TODO: Documentation
         */
        @Json(name = "photo")
        Photo("photo"),
        /**
         * TODO: Documentation
         */
        @Json(name = "quote")
        Quote("quote"),
        /**
         * TODO: Documentation
         */
        @Json(name = "text")
        Text("text"),
        /**
         * TODO: Documentation
         */
        @Json(name = "video")
        Video("video"),
        /**
         * TODO: Documentation
         */
        @Json(name = "blocks")
        Block("blocks")
    }

    /**
     * TODO: Documentation
     *
     * @param key TODO: Documentation
     */
    @JsonClass(generateAdapter = false)
    enum class PostFormat(val key: String) {
        /**
         * TODO: Documentation
         */
        @Json(name = "html")
        HTML("html"),
        /**
         * TODO: Documentation
         */
        @Json(name = "text")
        Plain("text"),
        /**
         * TODO: Documentation
         */
        @Json(name = "raw")
        Raw("raw")
    }

    /**
     * TODO: Documentation
     *
     * @param key TODO: Documentation
     */
    @JsonClass(generateAdapter = false)
    enum class PostVersion(val key: String) {
        /**
         * TODO: Documentation
         */
        @Json(name = "npf")
        NPF("npf"),
        /**
         * TODO: Documentation
         */
        @Json(name = "legacy")
        Legacy("legacy")
    }

    /**
     * TODO: Documentation
     *
     * @param key TODO: Documentation
     */
    @JsonClass(generateAdapter = false)
    enum class QueueState(val key: String) {
        /**
         * TODO: Documentation
         */
        @Json(name = "queued")
        Queued("queued")
    }
}
