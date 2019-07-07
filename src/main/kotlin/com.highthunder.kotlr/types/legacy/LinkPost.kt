package com.highthunder.kotlr.types.legacy

import com.highthunder.kotlr.types.Blog
import com.highthunder.kotlr.types.NoteData
import com.highthunder.kotlr.types.Post
import com.highthunder.kotlr.types.ReblogData
import com.highthunder.kotlr.types.Trail
import com.highthunder.kotlr.types.content.BlockLayout
import com.highthunder.kotlr.types.content.PostContent
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * LinkPost - A legacy link post.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 *
 * @param blogName The short name used to uniquely identify a blog.
 * @param id The post's unique ID.
 * @param blog A standard API-formatted "short blog info" object.
 * @param postUrl The location of the post.
 * @param timestamp The time of the post, in seconds since the epoch.
 * @param date The GMT date and time of the post, as a string.
 * @param format The post format: html, raw, or markdown.
 * @param reblogKey The key used to reblog this post.
 * @param tags Tags applied to the post.
 * @param isBookmarklet Indicates whether the post was created via the Tumblr bookmarklet.
 * @param isMobile Indicates whether the post was created via mobile/email publishing.
 * @param sourceUrl The URL for the source of the content (for quotes, reblogs, etc.).
 * @param sourceTitle The title of the source site.
 * @param isLiked Indicates if a user has already liked a post or not.
 * @param state Indicates the current state of the post.
 * @param totalPosts The total number of post available for this request, useful for paginating through results.
 * @param anonymous TODO: Documentation
 * @param content The array of content that constitutes the body of a post in the Neue Post Format(NPF).
 * @param trail The previous Posts in the reblog trail. In order of oldest (the root Post) to the newest (the parent Post).
 * @param layout The layouts of the blocks in this post.
 * @param postAuthor The id of the author of the post.
 * @param shortUrl The short URL for this post.
 * @param summary A short description of this post.
 * @param isBlocksFormat Indicates whether or not this post is using the new block format(NPF).
 * @param likedTimestamp The timestamp of when this post was liked.
 * @param slug The slug.
 * @param rebloggedFromId The ID of the post that this post reblogged.
 * @param rebloggedFromName The name of the blog that this post reblogged.
 * @param noteCount The note count for this post.
 * @param recommendedSource The source of a recommended post.
 * @param recommendedColor The recommended color for styling this post.
 * @param postAuthorIsAdult Indicates whether or not the author of this post is an adult only blog.
 * @param isSubmission Indicates whether or not this post is a submission.
 * @param canLike Indicates whether or not the current user can like this post.
 * @param canReblog Indicates whether or not the current user can reblog this post.
 * @param canSendInMessage Indicates whether or not this post can be sent in a message.
 * @param canReply Indicates whether or not the current user can reply to this post.
 * @param displayAvatar Indicates whether or not the poster's avatar should be shown with this post.
 * @param followed Indicates whether or not the current user follows the author of this post.
 * @param reblogData TODO: Documentation
 * @param rebloggedFromId The ID of the post that this post reblogged.
 * @param rebloggedFromUrl TODO: Documentation
 * @param rebloggedFromName The name of the blog that this post reblogged.
 * @param rebloggedFromTitle TODO: Documentation
 * @param rebloggedFromUuid TODO: Documentation
 * @param rebloggedFromCanMessage TODO: Documentation
 * @param rebloggedFromFollowing TODO: Documentation
 * @param rebloggedRootId The ID of the post that this post reblogged.
 * @param rebloggedRootUrl TODO: Documentation
 * @param rebloggedRootName The name of the blog that this post reblogged.
 * @param rebloggedRootTitle TODO: Documentation
 * @param rebloggedRootUuid TODO: Documentation
 * @param rebloggedRootCanMessage TODO: Documentation
 * @param rebloggedRootFollowing TODO: Documentation
 * @param notes TODO: Documentation
 *
 * Link Post
 * @param title The title of the page the link points to.
 * @param description A user-supplied description.
 * @param url The link!
 * @param author The author of the article the link points to.
 * @param linkAuthor TODO: Documentation
 * @param linkImage TODO: Documentation
 * @param linkImageDimensions TODO: Documentation
 * @param excerpt An excerpt from the article the link points to.
 * @param publisher The publisher of the article the link points to.
 * @param photos Photos to give a preview of the article that the link points to.
 * @param body TODO: Documentation
 */
@JsonClass(generateAdapter = true)
data class LinkPost constructor(
    @Json(name = "blog_name")
    override var blogName: String? = null,
    @Json(name = "id")
    override val id: Long? = null,
    @Json(name = "blog")
    override val blog: Blog? = null,
    @Json(name = "post_url")
    override val postUrl: String? = null,
    @Json(name = "timestamp")
    override val timestamp: Long? = null,
    @Json(name = "date")
    override val date: String? = null,
    @Json(name = "format")
    override var format: Post.PostFormat? = null,
    @Json(name = "reblog_key")
    override val reblogKey: String? = null,
    @Json(name = "tags")
    override var tags: List<String>? = null,
    @Json(name = "bookmarklet")
    override var isBookmarklet: Boolean? = null,
    @Json(name = "mobile")
    override var isMobile: Boolean? = null,
    @Json(name = "source_url")
    override var sourceUrl: String? = null,
    @Json(name = "source_title")
    override var sourceTitle: String? = null,
    @Json(name = "liked")
    override val isLiked: Boolean? = null,
    @Json(name = "state")
    override var state: Post.State? = null,
    @Json(name = "total_posts")
    override val totalPosts: Int? = null,
    @Json(name = "is_anonymous")
    override var anonymous: Boolean? = null,
    @Json(name = "content")
    override var content: List<PostContent>? = null,
    @Json(name = "trail")
    override var trail: List<Trail>? = null,
    @Json(name = "layout")
    override var layout: List<BlockLayout>? = null,
    @Json(name = "post_author")
    override var postAuthor: String? = null,
    @Json(name = "short_url")
    override var shortUrl: String? = null,
    @Json(name = "summary")
    override var summary: String? = null,
    @Json(name = "is_blocks_post_format")
    override var isBlocksFormat: Boolean? = null,
    @Json(name = "liked_timestamp")
    override val likedTimestamp: Long? = null,
    @Json(name = "slug")
    override var slug: String? = null,
    @Json(name = "note_count")
    override var noteCount: Long? = null,
    @Json(name = "recommended_source")
    override val recommendedSource: String? = null,
    @Json(name = "recommended_color")
    override val recommendedColor: String? = null,
    @Json(name = "post_author_is_adult")
    override val postAuthorIsAdult: Boolean? = null,
    @Json(name = "is_submission")
    override var isSubmission: Boolean? = null,
    @Json(name = "can_like")
    override var canLike: Boolean? = null,
    @Json(name = "can_reblog")
    override var canReblog: Boolean? = null,
    @Json(name = "can_send_in_message")
    override var canSendInMessage: Boolean? = null,
    @Json(name = "can_reply")
    override var canReply: Boolean? = null,
    @Json(name = "display_avatar")
    override val displayAvatar: Boolean? = null,
    @Json(name = "followed")
    override val followed: Boolean? = null,
    @Json(name = "reblog")
    override var reblogData: ReblogData? = null,
    @Json(name = "reblogged_from_id")
    override val rebloggedFromId: Long? = null,
    @Json(name = "reblogged_from_url")
    override val rebloggedFromUrl: String? = null,
    @Json(name = "reblogged_from_name")
    override val rebloggedFromName: String? = null,
    @Json(name = "reblogged_from_title")
    override val rebloggedFromTitle: String? = null,
    @Json(name = "reblogged_from_uuid")
    override val rebloggedFromUuid: String? = null,
    @Json(name = "reblogged_from_can_message")
    override val rebloggedFromCanMessage: Boolean? = null,
    @Json(name = "reblogged_from_following")
    override val rebloggedFromFollowing: Boolean? = null,
    @Json(name = "reblogged_root_id")
    override val rebloggedRootId: Long? = null,
    @Json(name = "reblogged_root_url")
    override val rebloggedRootUrl: String? = null,
    @Json(name = "reblogged_root_name")
    override val rebloggedRootName: String? = null,
    @Json(name = "reblogged_root_title")
    override val rebloggedRootTitle: String? = null,
    @Json(name = "reblogged_root_uuid")
    override val rebloggedRootUuid: String? = null,
    @Json(name = "reblogged_root_can_message")
    override val rebloggedRootCanMessage: Boolean? = null,
    @Json(name = "reblogged_root_following")
    override val rebloggedRootFollowing: Boolean? = null,
    @Json(name = "notes")
    override val notes: List<NoteData>? = null,
    @Json(name = "scheduled_publish_time")
    override val publishTime: Long?,
    @Json(name = "queued_state")
    override val queueState: Post.QueueState?,
    @Json(name = "should_open_in_legacy")
    override val shouldOpenInLegacy: Boolean?,
    @Json(name = "title")
    var title: String? = null,
    @Json(name = "description")
    var description: String? = null,
    @Json(name = "url")
    var url: String? = null,
    @Json(name = "author")
    var author: String? = null,
    @Json(name = "link_author")
    var linkAuthor: String? = null,
    @Json(name = "link_image")
    var linkImage: String? = null,
    @Json(name = "link_image_dimensions")
    var linkImageDimensions: PhotoSize? = null,
    @Json(name = "excerpt")
    var excerpt: String? = null,
    @Json(name = "publisher")
    var publisher: String? = null,
    @Json(name = "photos")
    var photos: List<Photo>? = null,
    @Json(name = "body")
    var body: String? = null
) : Post {
    override var type: String = Post.Type.Link.key
}
