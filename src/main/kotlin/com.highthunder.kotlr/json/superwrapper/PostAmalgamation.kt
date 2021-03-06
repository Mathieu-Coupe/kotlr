package com.highthunder.kotlr.json.superwrapper

import com.highthunder.kotlr.json.wrapper.PlayerWrapper
import com.highthunder.kotlr.types.BlockPost
import com.highthunder.kotlr.types.Blog
import com.highthunder.kotlr.types.NoteData
import com.highthunder.kotlr.types.Post
import com.highthunder.kotlr.types.ReblogData
import com.highthunder.kotlr.types.Trail
import com.highthunder.kotlr.types.content.BlockLayout
import com.highthunder.kotlr.types.content.PostContent
import com.highthunder.kotlr.types.legacy.AnswerPost
import com.highthunder.kotlr.types.legacy.AudioPost
import com.highthunder.kotlr.types.legacy.ChatPost
import com.highthunder.kotlr.types.legacy.Dialogue
import com.highthunder.kotlr.types.legacy.LinkPost
import com.highthunder.kotlr.types.legacy.Photo
import com.highthunder.kotlr.types.legacy.PhotoPost
import com.highthunder.kotlr.types.legacy.PhotoSize
import com.highthunder.kotlr.types.legacy.QuotePost
import com.highthunder.kotlr.types.legacy.TextPost
import com.highthunder.kotlr.types.legacy.Video
import com.highthunder.kotlr.types.legacy.VideoPost
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * PostAmalgamation - A class to hold every possible field for [Post] so that Mochi can
 * deserialize them.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 *
 * [Post]
 * @param type The type of the post.
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
 * @param isBlocksFormat Whether or not this post is using the new block format(NPF).
 * @param likedTimestamp The timestamp of when this post was liked.
 * @param slug The slug.
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
 * @param publishTime TODO: Documentation
 * @param queueState TODO: Documentation
 * @param parentPostId TODO: Documentation
 * @param parentBlogUUID TODO: Documentation
 *
 * [AnswerPost]
 * @param askingName The blog that sent this ask, or answered it if it was privately answered.
 * @param askingUrl The blog URL that sent this ask, or answered it if it was privately answered.
 * @param question The question being asked.
 * @param answer The answer given.
 * @param answerAbstract TODO: Documentation
 *
 * [AudioPost]
 * @param caption The user-supplied caption.
 *      NOTE: Duplicated by [photoPost,videoPost]
 * @param captionAbstract TODO: Documentation
 * @param embed HTML for embedding the audio player.
 * @param audio_url The url of the audio file.
 * @param plays Number of times the audio post has been played.
 * @param album_art Location of the audio file's ID3 album art image.
 * @param artist The audio file's ID3 artist value.
 * @param album The audio file's ID3 album value.
 * @param trackName The audio file's ID3 title value.
 * @param trackNumber The audio file's ID3 track value.
 * @param track TODO: Documentation
 * @param year The audio file's ID3 year value.
 * @param audioSourceUrl TODO: Documentation
 * @param audioType TODO: Documentation
 * @param external TODO: Documentation
 * @param providerUrl TODO: Documentation
 *
 * [ChatPost]
 * @param title The optional title of the post.
 *      NOTE: Duplicated by [linkPost, textPost]
 * @param body The full chat body.
 *      NOTE: Duplicated by [textPost,]
 * @param dialogue List of dialog objects describing the chat in detail.
 *
 * [LinkPost]
 * @param title The title of the page the link points to.
 *      NOTE: Duplicated from ChatPost
 * @param description A user-supplied description.
 * @param url The link!
 * @param author The author of the article the link points to.
 * @param linkAuthor TODO: Documentation
 * @param linkImage TODO: Documentation
 * @param linkImageDimensions TODO: Documentation
 * @param excerpt An excerpt from the article the link points to.
 * @param publisher The publisher of the article the link points to.
 * @param photos Photos to give a preview of the article that the link points to.
 *      NOTE: Duplicated by [photoPost,]
 * @param body The full post body.
 *      NOTE: Duplicated from ChatPost
 *
 * [PhotoPost]
 * @param caption The user-supplied caption.
 *      NOTE: Duplicated from AudioPost
 * @param width The width of the photo or photoset.
 * @param height The height of the photo or photoset.
 * @param photos The photos in this post.
 *      NOTE: Duplicated from LinkPost
 * @param imagePermalink A link to this image.
 * @param linkUrl TODO: Documentation
 * @param photosetLayout TODO: Documentation
 * @param panorama TODO: Documentation
 *
 * [QuotePost]
 * @param text The text of the quote (can be modified by the user when posting).
 * @param source Full HTML for the source of the quote Example: <a href="...">Steve Jobs</a>.
 *
 * [TextPost]
 * @param title The optional title of the post.
 *      NOTE: Duplicated from ChatPost
 * @param body The full post body.
 *      NOTE: Duplicated from ChatPost
 * @param abstract TODO: Documentation
 *
 * [VideoPost]
 * @param player The list of [Video]s in this post.
 * @param caption The user-supplied caption.
 *      NOTE: Duplicated from AudioPost
 * @param videoUrl A direct link to the video file.
 * @param html5Capable Indicates if this video is HTML5.
 * @param thumbnailUrl The location of the thumbnail of this video.
 * @param thumbnailWidth The width of the thumbnail.
 * @param thumbnailHeight The height of the thumbnail.
 * @param duration The length of this video in seconds.
 * @param videoType The source of this video (tumblr, youtube, instagram, vimeo, vine(rip), etc.).
 * @param videoData TODO: Documentation
 * @param permalinkUrl TODO: Documentation
 */
@JsonClass(generateAdapter = true)
internal data class PostAmalgamation(

    // region Defaults

    @Json(name = "type")
    val type: Post.Type? = null,
    @Json(name = "blog_name")
    val blogName: String? = null,
    @Json(name = "id")
    val id: Long? = null,
    @Json(name = "blog")
    val blog: Blog? = null,
    @Json(name = "post_url")
    val postUrl: String? = null,
    @Json(name = "timestamp")
    val timestamp: Long? = null,
    @Json(name = "date")
    val date: String? = null,
    @Json(name = "format")
    val format: Post.PostFormat? = null,
    @Json(name = "reblog_key")
    val reblogKey: String? = null,
    @Json(name = "tags")
    val tags: List<String>? = null,
    @Json(name = "bookmarklet")
    val isBookmarklet: Boolean? = null,
    @Json(name = "mobile")
    val isMobile: Boolean? = null,
    @Json(name = "source_url")
    val sourceUrl: String? = null,
    @Json(name = "source_title")
    val sourceTitle: String? = null,
    @Json(name = "liked")
    val isLiked: Boolean? = null,
    @Json(name = "state")
    val state: Post.State? = null,
    @Json(name = "total_posts")
    val totalPosts: Int? = null,
    @Json(name = "is_anonymous")
    val anonymous: Boolean? = null,

    // endregion

    // region Situational Fields

    @Json(name = "content")
    val content: List<PostContent>? = null,
    @Json(name = "trail")
    val trail: List<Trail>? = null,
    @Json(name = "layout")
    val layout: List<BlockLayout>? = null,
    @Json(name = "post_author")
    val postAuthor: String? = null,
    @Json(name = "short_url")
    val shortUrl: String? = null,
    @Json(name = "summary")
    val summary: String? = null,
    @Json(name = "is_blocks_post_format")
    val isBlocksFormat: Boolean? = null,
    @Json(name = "liked_timestamp")
    val likedTimestamp: Long? = null,
    @Json(name = "slug")
    val slug: String? = null,
    @Json(name = "note_count")
    val noteCount: Long? = null,
    @Json(name = "recommended_source")
    val recommendedSource: String? = null,
    @Json(name = "recommended_color")
    val recommendedColor: String? = null,
    @Json(name = "post_author_is_adult")
    val postAuthorIsAdult: Boolean? = null,
    @Json(name = "is_submission")
    val isSubmission: Boolean? = null,
    @Json(name = "can_like")
    val canLike: Boolean? = null,
    @Json(name = "can_reblog")
    val canReblog: Boolean? = null,
    @Json(name = "can_send_in_message")
    val canSendInMessage: Boolean? = null,
    @Json(name = "can_reply")
    val canReply: Boolean? = null,
    @Json(name = "display_avatar")
    val displayAvatar: Boolean? = null,
    @Json(name = "followed")
    val followed: Boolean? = null,
    @Json(name = "reblog")
    val reblogData: ReblogData? = null,
    @Json(name = "reblogged_from_id")
    val rebloggedFromId: Long? = null,
    @Json(name = "reblogged_from_url")
    val rebloggedFromUrl: String? = null,
    @Json(name = "reblogged_from_name")
    val rebloggedFromName: String? = null,
    @Json(name = "reblogged_from_title")
    val rebloggedFromTitle: String? = null,
    @Json(name = "reblogged_from_uuid")
    val rebloggedFromUuid: String? = null,
    @Json(name = "reblogged_from_can_message")
    val rebloggedFromCanMessage: Boolean? = null,
    @Json(name = "reblogged_from_following")
    val rebloggedFromFollowing: Boolean? = null,
    @Json(name = "reblogged_root_id")
    val rebloggedRootId: Long? = null,
    @Json(name = "reblogged_root_url")
    val rebloggedRootUrl: String? = null,
    @Json(name = "reblogged_root_name")
    val rebloggedRootName: String? = null,
    @Json(name = "reblogged_root_title")
    val rebloggedRootTitle: String? = null,
    @Json(name = "reblogged_root_uuid")
    val rebloggedRootUuid: String? = null,
    @Json(name = "reblogged_root_can_message")
    val rebloggedRootCanMessage: Boolean? = null,
    @Json(name = "reblogged_root_following")
    val rebloggedRootFollowing: Boolean? = null,
    @Json(name = "notes")
    val notes: List<NoteData>? = null,
    @Json(name = "scheduled_publish_time")
    val publishTime: Long? = null,
    @Json(name = "queued_state")
    val queueState: Post.QueueState? = null,
    @Json(name = "should_open_in_legacy")
    val shouldOpenInLegacy: Boolean? = null,
    @Json(name = "muted")
    val muted: Boolean? = null,
    @Json(name = "object_type")
    val objectType: String? = null,
    @Json(name = "tumblelog_uuid")
    val blogUUID: String? = null,
    @Json(name = "parent_post_id")
    val parentPostId: Long? = null,
    @Json(name = "parent_tumblelog_uuid")
    val parentBlogUUID: String? = null,

    // endregion

    // region Answer Post

    @Json(name = "asking_name")
    val askingName: String? = null,
    @Json(name = "asking_url")
    val askingUrl: String? = null,
    @Json(name = "question")
    val question: String? = null,
    @Json(name = "answer")
    val answer: String? = null,
    @Json(name = "answer_abstract")
    val answerAbstract: String? = null,

    // endregion

    // region Audio Post

    @Json(name = "caption")
    val caption: String? = null,
    @Json(name = "caption_abstract")
    val captionAbstract: String? = null,
    @Json(name = "embed")
    val embed: String? = null,
    @Json(name = "audio_url")
    val audio_url: String? = null,
    @Json(name = "plays")
    val plays: Int? = null,
    @Json(name = "album_art")
    val album_art: String? = null,
    @Json(name = "artist")
    val artist: String? = null,
    @Json(name = "album")
    val album: String? = null,
    @Json(name = "track_name")
    val trackName: String? = null,
    @Json(name = "track_number")
    val trackNumber: Int? = null,
    @Json(name = "track")
    val track: String? = null,
    @Json(name = "year")
    val year: Int? = null,
    @Json(name = "audio_source_url")
    val audioSourceUrl: String? = null,
    @Json(name = "audio_type")
    val audioType: String? = null,
    @Json(name = "is_external")
    val external: Boolean? = null,
    @Json(name = "provider_uri")
    val providerUrl: String? = null,

    // endregion

    // region Chat Post

    @Json(name = "title")
    val title: String? = null,
    @Json(name = "body")
    val body: String? = null,
    @Json(name = "dialogue")
    val dialogue: List<Dialogue>? = null,

    // endregion

    // region Link Post

    @Json(name = "description")
    val description: String? = null,
    @Json(name = "url")
    val url: String? = null,
    @Json(name = "author")
    val author: String? = null,
    @Json(name = "link_author")
    val linkAuthor: String? = null,
    @Json(name = "link_image")
    val linkImage: String? = null,
    @Json(name = "link_image_dimensions")
    val linkImageDimensions: PhotoSize? = null,
    @Json(name = "excerpt")
    val excerpt: String? = null,
    @Json(name = "publisher")
    val publisher: String? = null,
    @Json(name = "photos")
    val photos: List<Photo>? = null,

    // endregion

    // region Photo Post

    @Json(name = "width")
    val width: Int? = null,
    @Json(name = "height")
    val height: Int? = null,
    @Json(name = "image_permalink")
    val imagePermalink: String? = null,
    @Json(name = "link_url")
    val linkUrl: String? = null,
    @Json(name = "photoset_layout")
    val photosetLayout: String? = null,
    @Json(name = "is_panorama")
    val panorama: Boolean? = null,

    // endregion

    // region Quote Post

    @Json(name = "text")
    val text: String? = null,
    @Json(name = "source")
    val source: String? = null,

    // endregion

    // region Text Post

    @Json(name = "body_abstract")
    val abstract: String? = null,

    // endregion

    // region Video Post

    @Json(name = "player")
    val player: PlayerWrapper? = null,
    @Json(name = "video_url")
    val videoUrl: String? = null,
    @Json(name = "html5_capable")
    val html5Capable: Boolean? = null,
    @Json(name = "thumbnail_url")
    val thumbnailUrl: String? = null,
    @Json(name = "thumbnail_width")
    val thumbnailWidth: Int? = null,
    @Json(name = "thumbnail_height")
    val thumbnailHeight: Int? = null,
    @Json(name = "duration")
    val duration: Double? = null,
    @Json(name = "video_type")
    val videoType: String? = null,
    @Json(name = "video") // TODO: Figure out how to parse this one
    val videoData: Any? = null,
    @Json(name = "permalink_url")
    val permalinkUrl: String? = null

    // endregion

) {

    // region Answer Constructor

    constructor(post: AnswerPost) : this(
        type = Post.Type.Answer,
        blogName = post.blogName,
        id = post.id,
        blog = post.blog,
        postUrl = post.postUrl,
        timestamp = post.timestamp,
        date = post.date,
        format = post.format,
        reblogKey = post.reblogKey,
        tags = post.tags,
        isBookmarklet = post.isBookmarklet,
        isMobile = post.isMobile,
        sourceUrl = post.sourceUrl,
        sourceTitle = post.sourceTitle,
        isLiked = post.isLiked,
        state = post.state,
        totalPosts = post.totalPosts,
        anonymous = post.anonymous,
        content = post.content,
        trail = post.trail,
        layout = post.layout,
        postAuthor = post.postAuthor,
        shortUrl = post.shortUrl,
        summary = post.summary,
        isBlocksFormat = post.isBlocksFormat,
        likedTimestamp = post.likedTimestamp,
        slug = post.slug,
        noteCount = post.noteCount,
        recommendedSource = post.recommendedSource,
        recommendedColor = post.recommendedColor,
        postAuthorIsAdult = post.postAuthorIsAdult,
        isSubmission = post.isSubmission,
        canLike = post.canLike,
        canReblog = post.canReblog,
        canSendInMessage = post.canSendInMessage,
        canReply = post.canReply,
        displayAvatar = post.displayAvatar,
        followed = post.followed,
        reblogData = post.reblogData,
        rebloggedFromId = post.rebloggedFromId,
        rebloggedFromUrl = post.rebloggedFromUrl,
        rebloggedFromName = post.rebloggedFromName,
        rebloggedFromTitle = post.rebloggedFromTitle,
        rebloggedFromUuid = post.rebloggedFromUuid,
        rebloggedFromCanMessage = post.rebloggedFromCanMessage,
        rebloggedFromFollowing = post.rebloggedFromFollowing,
        rebloggedRootId = post.rebloggedRootId,
        rebloggedRootUrl = post.rebloggedRootUrl,
        rebloggedRootName = post.rebloggedRootName,
        rebloggedRootTitle = post.rebloggedRootTitle,
        rebloggedRootUuid = post.rebloggedRootUuid,
        rebloggedRootCanMessage = post.rebloggedRootCanMessage,
        rebloggedRootFollowing = post.rebloggedRootFollowing,
        notes = post.notes,
        publishTime = post.publishTime,
        queueState = post.queueState,
        shouldOpenInLegacy = post.shouldOpenInLegacy,
        muted = post.muted,
        objectType = post.objectType,
        blogUUID = post.blogUUID,
        parentPostId = post.parentPostId,
        parentBlogUUID = post.parentBlogUUID,

        askingName = post.askingName,
        askingUrl = post.askingUrl,
        question = post.question,
        answer = post.answer,
        answerAbstract = post.answerAbstract
    )

    // endregion

    // region Audio Constructor

    constructor(post: AudioPost) : this(
        type = Post.Type.Audio,
        blogName = post.blogName,
        id = post.id,
        blog = post.blog,
        postUrl = post.postUrl,
        timestamp = post.timestamp,
        date = post.date,
        format = post.format,
        reblogKey = post.reblogKey,
        tags = post.tags,
        isBookmarklet = post.isBookmarklet,
        isMobile = post.isMobile,
        sourceUrl = post.sourceUrl,
        sourceTitle = post.sourceTitle,
        isLiked = post.isLiked,
        state = post.state,
        totalPosts = post.totalPosts,
        anonymous = post.anonymous,
        content = post.content,
        trail = post.trail,
        layout = post.layout,
        postAuthor = post.postAuthor,
        shortUrl = post.shortUrl,
        summary = post.summary,
        isBlocksFormat = post.isBlocksFormat,
        likedTimestamp = post.likedTimestamp,
        slug = post.slug,
        noteCount = post.noteCount,
        recommendedSource = post.recommendedSource,
        recommendedColor = post.recommendedColor,
        postAuthorIsAdult = post.postAuthorIsAdult,
        isSubmission = post.isSubmission,
        canLike = post.canLike,
        canReblog = post.canReblog,
        canSendInMessage = post.canSendInMessage,
        canReply = post.canReply,
        displayAvatar = post.displayAvatar,
        followed = post.followed,
        reblogData = post.reblogData,
        rebloggedFromId = post.rebloggedFromId,
        rebloggedFromUrl = post.rebloggedFromUrl,
        rebloggedFromName = post.rebloggedFromName,
        rebloggedFromTitle = post.rebloggedFromTitle,
        rebloggedFromUuid = post.rebloggedFromUuid,
        rebloggedFromCanMessage = post.rebloggedFromCanMessage,
        rebloggedFromFollowing = post.rebloggedFromFollowing,
        rebloggedRootId = post.rebloggedRootId,
        rebloggedRootUrl = post.rebloggedRootUrl,
        rebloggedRootName = post.rebloggedRootName,
        rebloggedRootTitle = post.rebloggedRootTitle,
        rebloggedRootUuid = post.rebloggedRootUuid,
        rebloggedRootCanMessage = post.rebloggedRootCanMessage,
        rebloggedRootFollowing = post.rebloggedRootFollowing,
        notes = post.notes,
        publishTime = post.publishTime,
        queueState = post.queueState,
        shouldOpenInLegacy = post.shouldOpenInLegacy,
        muted = post.muted,
        objectType = post.objectType,
        blogUUID = post.blogUUID,
        parentPostId = post.parentPostId,
        parentBlogUUID = post.parentBlogUUID,

        caption = post.caption,
        captionAbstract = post.captionAbstract,
        player = PlayerWrapper(contentString = post.player),
        audio_url = post.audioUrl,
        plays = post.plays,
        album_art = post.album_art,
        artist = post.artist,
        album = post.album,
        trackName = post.trackName,
        trackNumber = post.trackNumber,
        track = post.track,
        year = post.year,
        external = post.external,
        providerUrl = post.providerUrl,
        audioSourceUrl = post.audioSourceUrl,
        audioType = post.audioType,
        embed = post.embed
    )

    // endregion

    // region Chat Constructor

    constructor(post: ChatPost) : this(
        type = Post.Type.Chat,
        blogName = post.blogName,
        id = post.id,
        blog = post.blog,
        postUrl = post.postUrl,
        timestamp = post.timestamp,
        date = post.date,
        format = post.format,
        reblogKey = post.reblogKey,
        tags = post.tags,
        isBookmarklet = post.isBookmarklet,
        isMobile = post.isMobile,
        sourceUrl = post.sourceUrl,
        sourceTitle = post.sourceTitle,
        isLiked = post.isLiked,
        state = post.state,
        totalPosts = post.totalPosts,
        anonymous = post.anonymous,
        content = post.content,
        trail = post.trail,
        layout = post.layout,
        postAuthor = post.postAuthor,
        shortUrl = post.shortUrl,
        summary = post.summary,
        isBlocksFormat = post.isBlocksFormat,
        likedTimestamp = post.likedTimestamp,
        slug = post.slug,
        noteCount = post.noteCount,
        recommendedSource = post.recommendedSource,
        recommendedColor = post.recommendedColor,
        postAuthorIsAdult = post.postAuthorIsAdult,
        isSubmission = post.isSubmission,
        canLike = post.canLike,
        canReblog = post.canReblog,
        canSendInMessage = post.canSendInMessage,
        canReply = post.canReply,
        displayAvatar = post.displayAvatar,
        followed = post.followed,
        reblogData = post.reblogData,
        rebloggedFromId = post.rebloggedFromId,
        rebloggedFromUrl = post.rebloggedFromUrl,
        rebloggedFromName = post.rebloggedFromName,
        rebloggedFromTitle = post.rebloggedFromTitle,
        rebloggedFromUuid = post.rebloggedFromUuid,
        rebloggedFromCanMessage = post.rebloggedFromCanMessage,
        rebloggedFromFollowing = post.rebloggedFromFollowing,
        rebloggedRootId = post.rebloggedRootId,
        rebloggedRootUrl = post.rebloggedRootUrl,
        rebloggedRootName = post.rebloggedRootName,
        rebloggedRootTitle = post.rebloggedRootTitle,
        rebloggedRootUuid = post.rebloggedRootUuid,
        rebloggedRootCanMessage = post.rebloggedRootCanMessage,
        rebloggedRootFollowing = post.rebloggedRootFollowing,
        notes = post.notes,
        publishTime = post.publishTime,
        queueState = post.queueState,
        shouldOpenInLegacy = post.shouldOpenInLegacy,
        muted = post.muted,
        objectType = post.objectType,
        blogUUID = post.blogUUID,
        parentPostId = post.parentPostId,
        parentBlogUUID = post.parentBlogUUID,

        title = post.title,
        body = post.body,
        dialogue = post.dialogue
    )

    // endregion

    // region Link Constructor

    constructor(post: LinkPost) : this(
        type = Post.Type.Link,
        blogName = post.blogName,
        id = post.id,
        blog = post.blog,
        postUrl = post.postUrl,
        timestamp = post.timestamp,
        date = post.date,
        format = post.format,
        reblogKey = post.reblogKey,
        tags = post.tags,
        isBookmarklet = post.isBookmarklet,
        isMobile = post.isMobile,
        sourceUrl = post.sourceUrl,
        sourceTitle = post.sourceTitle,
        isLiked = post.isLiked,
        state = post.state,
        totalPosts = post.totalPosts,
        anonymous = post.anonymous,
        content = post.content,
        trail = post.trail,
        layout = post.layout,
        postAuthor = post.postAuthor,
        shortUrl = post.shortUrl,
        summary = post.summary,
        isBlocksFormat = post.isBlocksFormat,
        likedTimestamp = post.likedTimestamp,
        slug = post.slug,
        noteCount = post.noteCount,
        recommendedSource = post.recommendedSource,
        recommendedColor = post.recommendedColor,
        postAuthorIsAdult = post.postAuthorIsAdult,
        isSubmission = post.isSubmission,
        canLike = post.canLike,
        canReblog = post.canReblog,
        canSendInMessage = post.canSendInMessage,
        canReply = post.canReply,
        displayAvatar = post.displayAvatar,
        followed = post.followed,
        reblogData = post.reblogData,
        rebloggedFromId = post.rebloggedFromId,
        rebloggedFromUrl = post.rebloggedFromUrl,
        rebloggedFromName = post.rebloggedFromName,
        rebloggedFromTitle = post.rebloggedFromTitle,
        rebloggedFromUuid = post.rebloggedFromUuid,
        rebloggedFromCanMessage = post.rebloggedFromCanMessage,
        rebloggedFromFollowing = post.rebloggedFromFollowing,
        rebloggedRootId = post.rebloggedRootId,
        rebloggedRootUrl = post.rebloggedRootUrl,
        rebloggedRootName = post.rebloggedRootName,
        rebloggedRootTitle = post.rebloggedRootTitle,
        rebloggedRootUuid = post.rebloggedRootUuid,
        rebloggedRootCanMessage = post.rebloggedRootCanMessage,
        rebloggedRootFollowing = post.rebloggedRootFollowing,
        notes = post.notes,
        publishTime = post.publishTime,
        queueState = post.queueState,
        shouldOpenInLegacy = post.shouldOpenInLegacy,
        muted = post.muted,
        objectType = post.objectType,
        blogUUID = post.blogUUID,
        parentPostId = post.parentPostId,
        parentBlogUUID = post.parentBlogUUID,

        title = post.title,
        description = post.description,
        url = post.url,
        author = post.author,
        linkAuthor = post.linkAuthor,
        linkImage = post.linkImage,
        linkImageDimensions = post.linkImageDimensions,
        excerpt = post.excerpt,
        publisher = post.publisher,
        photos = post.photos,
        body = post.body
    )

    // endregion

    // region Photo Constructor

    constructor(post: PhotoPost) : this(
        type = Post.Type.Photo,
        blogName = post.blogName,
        id = post.id,
        blog = post.blog,
        postUrl = post.postUrl,
        timestamp = post.timestamp,
        date = post.date,
        format = post.format,
        reblogKey = post.reblogKey,
        tags = post.tags,
        isBookmarklet = post.isBookmarklet,
        isMobile = post.isMobile,
        sourceUrl = post.sourceUrl,
        sourceTitle = post.sourceTitle,
        isLiked = post.isLiked,
        state = post.state,
        totalPosts = post.totalPosts,
        anonymous = post.anonymous,
        content = post.content,
        trail = post.trail,
        layout = post.layout,
        postAuthor = post.postAuthor,
        shortUrl = post.shortUrl,
        summary = post.summary,
        isBlocksFormat = post.isBlocksFormat,
        likedTimestamp = post.likedTimestamp,
        slug = post.slug,
        noteCount = post.noteCount,
        recommendedSource = post.recommendedSource,
        recommendedColor = post.recommendedColor,
        postAuthorIsAdult = post.postAuthorIsAdult,
        isSubmission = post.isSubmission,
        canLike = post.canLike,
        canReblog = post.canReblog,
        canSendInMessage = post.canSendInMessage,
        canReply = post.canReply,
        displayAvatar = post.displayAvatar,
        followed = post.followed,
        reblogData = post.reblogData,
        rebloggedFromId = post.rebloggedFromId,
        rebloggedFromUrl = post.rebloggedFromUrl,
        rebloggedFromName = post.rebloggedFromName,
        rebloggedFromTitle = post.rebloggedFromTitle,
        rebloggedFromUuid = post.rebloggedFromUuid,
        rebloggedFromCanMessage = post.rebloggedFromCanMessage,
        rebloggedFromFollowing = post.rebloggedFromFollowing,
        rebloggedRootId = post.rebloggedRootId,
        rebloggedRootUrl = post.rebloggedRootUrl,
        rebloggedRootName = post.rebloggedRootName,
        rebloggedRootTitle = post.rebloggedRootTitle,
        rebloggedRootUuid = post.rebloggedRootUuid,
        rebloggedRootCanMessage = post.rebloggedRootCanMessage,
        rebloggedRootFollowing = post.rebloggedRootFollowing,
        notes = post.notes,
        publishTime = post.publishTime,
        queueState = post.queueState,
        shouldOpenInLegacy = post.shouldOpenInLegacy,
        muted = post.muted,
        objectType = post.objectType,
        blogUUID = post.blogUUID,
        parentPostId = post.parentPostId,
        parentBlogUUID = post.parentBlogUUID,

        caption = post.caption,
        captionAbstract = post.captionAbstract,
        width = post.width,
        height = post.height,
        photos = post.photos,
        linkUrl = post.linkUrl,
        imagePermalink = post.imagePermalink,
        panorama = post.panorama,
        photosetLayout = post.photosetLayout
    )

    // endregion

    // region Quote Constructor

    constructor(post: QuotePost) : this(
        type = Post.Type.Quote,
        blogName = post.blogName,
        id = post.id,
        blog = post.blog,
        postUrl = post.postUrl,
        timestamp = post.timestamp,
        date = post.date,
        format = post.format,
        reblogKey = post.reblogKey,
        tags = post.tags,
        isBookmarklet = post.isBookmarklet,
        isMobile = post.isMobile,
        sourceUrl = post.sourceUrl,
        sourceTitle = post.sourceTitle,
        isLiked = post.isLiked,
        state = post.state,
        totalPosts = post.totalPosts,
        anonymous = post.anonymous,
        content = post.content,
        trail = post.trail,
        layout = post.layout,
        postAuthor = post.postAuthor,
        shortUrl = post.shortUrl,
        summary = post.summary,
        isBlocksFormat = post.isBlocksFormat,
        likedTimestamp = post.likedTimestamp,
        slug = post.slug,
        noteCount = post.noteCount,
        recommendedSource = post.recommendedSource,
        recommendedColor = post.recommendedColor,
        postAuthorIsAdult = post.postAuthorIsAdult,
        isSubmission = post.isSubmission,
        canLike = post.canLike,
        canReblog = post.canReblog,
        canSendInMessage = post.canSendInMessage,
        canReply = post.canReply,
        displayAvatar = post.displayAvatar,
        followed = post.followed,
        reblogData = post.reblogData,
        rebloggedFromId = post.rebloggedFromId,
        rebloggedFromUrl = post.rebloggedFromUrl,
        rebloggedFromName = post.rebloggedFromName,
        rebloggedFromTitle = post.rebloggedFromTitle,
        rebloggedFromUuid = post.rebloggedFromUuid,
        rebloggedFromCanMessage = post.rebloggedFromCanMessage,
        rebloggedFromFollowing = post.rebloggedFromFollowing,
        rebloggedRootId = post.rebloggedRootId,
        rebloggedRootUrl = post.rebloggedRootUrl,
        rebloggedRootName = post.rebloggedRootName,
        rebloggedRootTitle = post.rebloggedRootTitle,
        rebloggedRootUuid = post.rebloggedRootUuid,
        rebloggedRootCanMessage = post.rebloggedRootCanMessage,
        rebloggedRootFollowing = post.rebloggedRootFollowing,
        notes = post.notes,
        publishTime = post.publishTime,
        queueState = post.queueState,
        shouldOpenInLegacy = post.shouldOpenInLegacy,
        muted = post.muted,
        objectType = post.objectType,
        blogUUID = post.blogUUID,
        parentPostId = post.parentPostId,
        parentBlogUUID = post.parentBlogUUID,

        text = post.text,
        source = post.source
    )

    // endregion

    // region Text Constructor

    constructor(post: TextPost) : this(
        type = Post.Type.Text,
        blogName = post.blogName,
        id = post.id,
        blog = post.blog,
        postUrl = post.postUrl,
        timestamp = post.timestamp,
        date = post.date,
        format = post.format,
        reblogKey = post.reblogKey,
        tags = post.tags,
        isBookmarklet = post.isBookmarklet,
        isMobile = post.isMobile,
        sourceUrl = post.sourceUrl,
        sourceTitle = post.sourceTitle,
        isLiked = post.isLiked,
        state = post.state,
        totalPosts = post.totalPosts,
        anonymous = post.anonymous,
        content = post.content,
        trail = post.trail,
        layout = post.layout,
        postAuthor = post.postAuthor,
        shortUrl = post.shortUrl,
        summary = post.summary,
        isBlocksFormat = post.isBlocksFormat,
        likedTimestamp = post.likedTimestamp,
        slug = post.slug,
        noteCount = post.noteCount,
        recommendedSource = post.recommendedSource,
        recommendedColor = post.recommendedColor,
        postAuthorIsAdult = post.postAuthorIsAdult,
        isSubmission = post.isSubmission,
        canLike = post.canLike,
        canReblog = post.canReblog,
        canSendInMessage = post.canSendInMessage,
        canReply = post.canReply,
        displayAvatar = post.displayAvatar,
        followed = post.followed,
        reblogData = post.reblogData,
        rebloggedFromId = post.rebloggedFromId,
        rebloggedFromUrl = post.rebloggedFromUrl,
        rebloggedFromName = post.rebloggedFromName,
        rebloggedFromTitle = post.rebloggedFromTitle,
        rebloggedFromUuid = post.rebloggedFromUuid,
        rebloggedFromCanMessage = post.rebloggedFromCanMessage,
        rebloggedFromFollowing = post.rebloggedFromFollowing,
        rebloggedRootId = post.rebloggedRootId,
        rebloggedRootUrl = post.rebloggedRootUrl,
        rebloggedRootName = post.rebloggedRootName,
        rebloggedRootTitle = post.rebloggedRootTitle,
        rebloggedRootUuid = post.rebloggedRootUuid,
        rebloggedRootCanMessage = post.rebloggedRootCanMessage,
        rebloggedRootFollowing = post.rebloggedRootFollowing,
        notes = post.notes,
        publishTime = post.publishTime,
        queueState = post.queueState,
        shouldOpenInLegacy = post.shouldOpenInLegacy,
        muted = post.muted,
        objectType = post.objectType,
        blogUUID = post.blogUUID,
        parentPostId = post.parentPostId,
        parentBlogUUID = post.parentBlogUUID,

        title = post.title,
        abstract = post.abstract,
        body = post.body
    )

    // endregion

    // region Video Constructor

    constructor(post: VideoPost) : this(
        type = Post.Type.Video,
        blogName = post.blogName,
        id = post.id,
        blog = post.blog,
        postUrl = post.postUrl,
        timestamp = post.timestamp,
        date = post.date,
        format = post.format,
        reblogKey = post.reblogKey,
        tags = post.tags,
        isBookmarklet = post.isBookmarklet,
        isMobile = post.isMobile,
        sourceUrl = post.sourceUrl,
        sourceTitle = post.sourceTitle,
        isLiked = post.isLiked,
        state = post.state,
        totalPosts = post.totalPosts,
        anonymous = post.anonymous,
        content = post.content,
        trail = post.trail,
        layout = post.layout,
        postAuthor = post.postAuthor,
        shortUrl = post.shortUrl,
        summary = post.summary,
        isBlocksFormat = post.isBlocksFormat,
        likedTimestamp = post.likedTimestamp,
        slug = post.slug,
        noteCount = post.noteCount,
        recommendedSource = post.recommendedSource,
        recommendedColor = post.recommendedColor,
        postAuthorIsAdult = post.postAuthorIsAdult,
        isSubmission = post.isSubmission,
        canLike = post.canLike,
        canReblog = post.canReblog,
        canSendInMessage = post.canSendInMessage,
        canReply = post.canReply,
        displayAvatar = post.displayAvatar,
        followed = post.followed,
        reblogData = post.reblogData,
        rebloggedFromId = post.rebloggedFromId,
        rebloggedFromUrl = post.rebloggedFromUrl,
        rebloggedFromName = post.rebloggedFromName,
        rebloggedFromTitle = post.rebloggedFromTitle,
        rebloggedFromUuid = post.rebloggedFromUuid,
        rebloggedFromCanMessage = post.rebloggedFromCanMessage,
        rebloggedFromFollowing = post.rebloggedFromFollowing,
        rebloggedRootId = post.rebloggedRootId,
        rebloggedRootUrl = post.rebloggedRootUrl,
        rebloggedRootName = post.rebloggedRootName,
        rebloggedRootTitle = post.rebloggedRootTitle,
        rebloggedRootUuid = post.rebloggedRootUuid,
        rebloggedRootCanMessage = post.rebloggedRootCanMessage,
        rebloggedRootFollowing = post.rebloggedRootFollowing,
        notes = post.notes,
        publishTime = post.publishTime,
        queueState = post.queueState,
        shouldOpenInLegacy = post.shouldOpenInLegacy,
        muted = post.muted,
        objectType = post.objectType,
        blogUUID = post.blogUUID,
        parentPostId = post.parentPostId,
        parentBlogUUID = post.parentBlogUUID,

        player = PlayerWrapper(contentList = post.player),
        caption = post.caption,
        videoUrl = post.videoUrl,
        html5Capable = post.html5Capable,
        thumbnailUrl = post.thumbnailUrl,
        thumbnailWidth = post.thumbnailWidth,
        thumbnailHeight = post.thumbnailHeight,
        duration = post.duration,
        videoData = post.videoData,
        permalinkUrl = post.permalinkUrl,
        videoType = post.videoType
    )

    // endregion

    // region Block Constructor

    constructor(post: BlockPost) : this(
        type = Post.Type.Block,
        blogName = post.blogName,
        id = post.id,
        blog = post.blog,
        postUrl = post.postUrl,
        timestamp = post.timestamp,
        date = post.date,
        format = post.format,
        reblogKey = post.reblogKey,
        tags = post.tags,
        isBookmarklet = post.isBookmarklet,
        isMobile = post.isMobile,
        sourceUrl = post.sourceUrl,
        sourceTitle = post.sourceTitle,
        isLiked = post.isLiked,
        state = post.state,
        totalPosts = post.totalPosts,
        anonymous = post.anonymous,
        content = post.content,
        trail = post.trail,
        layout = post.layout,
        postAuthor = post.postAuthor,
        shortUrl = post.shortUrl,
        summary = post.summary,
        isBlocksFormat = post.isBlocksFormat,
        likedTimestamp = post.likedTimestamp,
        slug = post.slug,
        noteCount = post.noteCount,
        recommendedSource = post.recommendedSource,
        recommendedColor = post.recommendedColor,
        postAuthorIsAdult = post.postAuthorIsAdult,
        isSubmission = post.isSubmission,
        canLike = post.canLike,
        canReblog = post.canReblog,
        canSendInMessage = post.canSendInMessage,
        canReply = post.canReply,
        displayAvatar = post.displayAvatar,
        followed = post.followed,
        reblogData = post.reblogData,
        rebloggedFromId = post.rebloggedFromId,
        rebloggedFromUrl = post.rebloggedFromUrl,
        rebloggedFromName = post.rebloggedFromName,
        rebloggedFromTitle = post.rebloggedFromTitle,
        rebloggedFromUuid = post.rebloggedFromUuid,
        rebloggedFromCanMessage = post.rebloggedFromCanMessage,
        rebloggedFromFollowing = post.rebloggedFromFollowing,
        rebloggedRootId = post.rebloggedRootId,
        rebloggedRootUrl = post.rebloggedRootUrl,
        rebloggedRootName = post.rebloggedRootName,
        rebloggedRootTitle = post.rebloggedRootTitle,
        rebloggedRootUuid = post.rebloggedRootUuid,
        rebloggedRootCanMessage = post.rebloggedRootCanMessage,
        rebloggedRootFollowing = post.rebloggedRootFollowing,
        notes = post.notes,
        publishTime = post.publishTime,
        queueState = post.queueState,
        shouldOpenInLegacy = post.shouldOpenInLegacy,
        muted = post.muted,
        objectType = post.objectType,
        blogUUID = post.blogUUID,
        parentPostId = post.parentPostId,
        parentBlogUUID = post.parentBlogUUID
    )

    // endregion

    fun toAnswerPost(): AnswerPost {
        return AnswerPost(
            blogName,
            id,
            blog,
            postUrl,
            timestamp,
            date,
            format,
            reblogKey,
            tags,
            isBookmarklet,
            isMobile,
            sourceUrl,
            sourceTitle,
            isLiked,
            state,
            totalPosts,
            anonymous,
            content,
            trail,
            layout,
            postAuthor,
            shortUrl,
            summary,
            isBlocksFormat,
            likedTimestamp,
            slug,
            noteCount,
            recommendedSource,
            recommendedColor,
            postAuthorIsAdult,
            isSubmission,
            canLike,
            canReblog,
            canSendInMessage,
            canReply,
            displayAvatar,
            followed,
            reblogData,
            rebloggedFromId,
            rebloggedFromUrl,
            rebloggedFromName,
            rebloggedFromTitle,
            rebloggedFromUuid,
            rebloggedFromCanMessage,
            rebloggedFromFollowing,
            rebloggedRootId,
            rebloggedRootUrl,
            rebloggedRootName,
            rebloggedRootTitle,
            rebloggedRootUuid,
            rebloggedRootCanMessage,
            rebloggedRootFollowing,
            notes,
            publishTime,
            queueState,
            shouldOpenInLegacy,
            muted,
            objectType,
            blogUUID,
            parentPostId,
            parentBlogUUID,

            askingName,
            askingUrl,
            question,
            answer,
            answerAbstract
        )
    }

    fun toAudioPost(): AudioPost {
        return AudioPost(
            blogName,
            id,
            blog,
            postUrl,
            timestamp,
            date,
            format,
            reblogKey,
            tags,
            isBookmarklet,
            isMobile,
            sourceUrl,
            sourceTitle,
            isLiked,
            state,
            totalPosts,
            anonymous,
            content,
            trail,
            layout,
            postAuthor,
            shortUrl,
            summary,
            isBlocksFormat,
            likedTimestamp,
            slug,
            noteCount,
            recommendedSource,
            recommendedColor,
            postAuthorIsAdult,
            isSubmission,
            canLike,
            canReblog,
            canSendInMessage,
            canReply,
            displayAvatar,
            followed,
            reblogData,
            rebloggedFromId,
            rebloggedFromUrl,
            rebloggedFromName,
            rebloggedFromTitle,
            rebloggedFromUuid,
            rebloggedFromCanMessage,
            rebloggedFromFollowing,
            rebloggedRootId,
            rebloggedRootUrl,
            rebloggedRootName,
            rebloggedRootTitle,
            rebloggedRootUuid,
            rebloggedRootCanMessage,
            rebloggedRootFollowing,
            notes,
            publishTime,
            queueState,
            shouldOpenInLegacy,
            muted,
            objectType,
            blogUUID,
            parentPostId,
            parentBlogUUID,

            caption,
            captionAbstract,
            player?.contentString,
            audio_url,
            plays,
            album_art,
            artist,
            album,
            trackName,
            trackNumber,
            track,
            year,
            external,
            providerUrl,
            audioSourceUrl,
            audioType,
            embed
        )
    }

    fun toChatPost(): ChatPost {
        return ChatPost(
            blogName,
            id,
            blog,
            postUrl,
            timestamp,
            date,
            format,
            reblogKey,
            tags,
            isBookmarklet,
            isMobile,
            sourceUrl,
            sourceTitle,
            isLiked,
            state,
            totalPosts,
            anonymous,
            content,
            trail,
            layout,
            postAuthor,
            shortUrl,
            summary,
            isBlocksFormat,
            likedTimestamp,
            slug,
            noteCount,
            recommendedSource,
            recommendedColor,
            postAuthorIsAdult,
            isSubmission,
            canLike,
            canReblog,
            canSendInMessage,
            canReply,
            displayAvatar,
            followed,
            reblogData,
            rebloggedFromId,
            rebloggedFromUrl,
            rebloggedFromName,
            rebloggedFromTitle,
            rebloggedFromUuid,
            rebloggedFromCanMessage,
            rebloggedFromFollowing,
            rebloggedRootId,
            rebloggedRootUrl,
            rebloggedRootName,
            rebloggedRootTitle,
            rebloggedRootUuid,
            rebloggedRootCanMessage,
            rebloggedRootFollowing,
            notes,
            publishTime,
            queueState,
            shouldOpenInLegacy,
            muted,
            objectType,
            blogUUID,
            parentPostId,
            parentBlogUUID,

            title,
            body,
            dialogue
        )
    }

    fun toLinkPost(): LinkPost {
        return LinkPost(
            blogName,
            id,
            blog,
            postUrl,
            timestamp,
            date,
            format,
            reblogKey,
            tags,
            isBookmarklet,
            isMobile,
            sourceUrl,
            sourceTitle,
            isLiked,
            state,
            totalPosts,
            anonymous,
            content,
            trail,
            layout,
            postAuthor,
            shortUrl,
            summary,
            isBlocksFormat,
            likedTimestamp,
            slug,
            noteCount,
            recommendedSource,
            recommendedColor,
            postAuthorIsAdult,
            isSubmission,
            canLike,
            canReblog,
            canSendInMessage,
            canReply,
            displayAvatar,
            followed,
            reblogData,
            rebloggedFromId,
            rebloggedFromUrl,
            rebloggedFromName,
            rebloggedFromTitle,
            rebloggedFromUuid,
            rebloggedFromCanMessage,
            rebloggedFromFollowing,
            rebloggedRootId,
            rebloggedRootUrl,
            rebloggedRootName,
            rebloggedRootTitle,
            rebloggedRootUuid,
            rebloggedRootCanMessage,
            rebloggedRootFollowing,
            notes,
            publishTime,
            queueState,
            shouldOpenInLegacy,
            muted,
            objectType,
            blogUUID,
            parentPostId,
            parentBlogUUID,

            title,
            description,
            url,
            author,
            linkAuthor,
            linkImage,
            linkImageDimensions,
            excerpt,
            publisher,
            photos,
            body
        )
    }

    fun toPhotoPost(): PhotoPost {
        return PhotoPost(
            blogName,
            id,
            blog,
            postUrl,
            timestamp,
            date,
            format,
            reblogKey,
            tags,
            isBookmarklet,
            isMobile,
            sourceUrl,
            sourceTitle,
            isLiked,
            state,
            totalPosts,
            anonymous,
            content,
            trail,
            layout,
            postAuthor,
            shortUrl,
            summary,
            isBlocksFormat,
            likedTimestamp,
            slug,
            noteCount,
            recommendedSource,
            recommendedColor,
            postAuthorIsAdult,
            isSubmission,
            canLike,
            canReblog,
            canSendInMessage,
            canReply,
            displayAvatar,
            followed,
            reblogData,
            rebloggedFromId,
            rebloggedFromUrl,
            rebloggedFromName,
            rebloggedFromTitle,
            rebloggedFromUuid,
            rebloggedFromCanMessage,
            rebloggedFromFollowing,
            rebloggedRootId,
            rebloggedRootUrl,
            rebloggedRootName,
            rebloggedRootTitle,
            rebloggedRootUuid,
            rebloggedRootCanMessage,
            rebloggedRootFollowing,
            notes,
            publishTime,
            queueState,
            shouldOpenInLegacy,
            muted,
            objectType,
            blogUUID,
            parentPostId,
            parentBlogUUID,

            caption,
            captionAbstract,
            width,
            height,
            photos,
            linkUrl,
            imagePermalink,
            panorama,
            photosetLayout
        )
    }

    fun toQuotePost(): QuotePost {
        return QuotePost(
            blogName,
            id,
            blog,
            postUrl,
            timestamp,
            date,
            format,
            reblogKey,
            tags,
            isBookmarklet,
            isMobile,
            sourceUrl,
            sourceTitle,
            isLiked,
            state,
            totalPosts,
            anonymous,
            content,
            trail,
            layout,
            postAuthor,
            shortUrl,
            summary,
            isBlocksFormat,
            likedTimestamp,
            slug,
            noteCount,
            recommendedSource,
            recommendedColor,
            postAuthorIsAdult,
            isSubmission,
            canLike,
            canReblog,
            canSendInMessage,
            canReply,
            displayAvatar,
            followed,
            reblogData,
            rebloggedFromId,
            rebloggedFromUrl,
            rebloggedFromName,
            rebloggedFromTitle,
            rebloggedFromUuid,
            rebloggedFromCanMessage,
            rebloggedFromFollowing,
            rebloggedRootId,
            rebloggedRootUrl,
            rebloggedRootName,
            rebloggedRootTitle,
            rebloggedRootUuid,
            rebloggedRootCanMessage,
            rebloggedRootFollowing,
            notes,
            publishTime,
            queueState,
            shouldOpenInLegacy,
            muted,
            objectType,
            blogUUID,
            parentPostId,
            parentBlogUUID,

            text,
            source
        )
    }

    fun toTextPost(): TextPost {
        return TextPost(
            blogName,
            id,
            blog,
            postUrl,
            timestamp,
            date,
            format,
            reblogKey,
            tags,
            isBookmarklet,
            isMobile,
            sourceUrl,
            sourceTitle,
            isLiked,
            state,
            totalPosts,
            anonymous,
            content,
            trail,
            layout,
            postAuthor,
            shortUrl,
            summary,
            isBlocksFormat,
            likedTimestamp,
            slug,
            noteCount,
            recommendedSource,
            recommendedColor,
            postAuthorIsAdult,
            isSubmission,
            canLike,
            canReblog,
            canSendInMessage,
            canReply,
            displayAvatar,
            followed,
            reblogData,
            rebloggedFromId,
            rebloggedFromUrl,
            rebloggedFromName,
            rebloggedFromTitle,
            rebloggedFromUuid,
            rebloggedFromCanMessage,
            rebloggedFromFollowing,
            rebloggedRootId,
            rebloggedRootUrl,
            rebloggedRootName,
            rebloggedRootTitle,
            rebloggedRootUuid,
            rebloggedRootCanMessage,
            rebloggedRootFollowing,
            notes,
            publishTime,
            queueState,
            shouldOpenInLegacy,
            muted,
            objectType,
            blogUUID,
            parentPostId,
            parentBlogUUID,

            title,
            abstract,
            body
        )
    }

    fun toVideoPost(): VideoPost {
        return VideoPost(
            blogName,
            id,
            blog,
            postUrl,
            timestamp,
            date,
            format,
            reblogKey,
            tags,
            isBookmarklet,
            isMobile,
            sourceUrl,
            sourceTitle,
            isLiked,
            state,
            totalPosts,
            anonymous,
            content,
            trail,
            layout,
            postAuthor,
            shortUrl,
            summary,
            isBlocksFormat,
            likedTimestamp,
            slug,
            noteCount,
            recommendedSource,
            recommendedColor,
            postAuthorIsAdult,
            isSubmission,
            canLike,
            canReblog,
            canSendInMessage,
            canReply,
            displayAvatar,
            followed,
            reblogData,
            rebloggedFromId,
            rebloggedFromUrl,
            rebloggedFromName,
            rebloggedFromTitle,
            rebloggedFromUuid,
            rebloggedFromCanMessage,
            rebloggedFromFollowing,
            rebloggedRootId,
            rebloggedRootUrl,
            rebloggedRootName,
            rebloggedRootTitle,
            rebloggedRootUuid,
            rebloggedRootCanMessage,
            rebloggedRootFollowing,
            notes,
            publishTime,
            queueState,
            shouldOpenInLegacy,
            muted,
            objectType,
            blogUUID,
            parentPostId,
            parentBlogUUID,

            player?.contentList,
            caption,
            videoUrl,
            html5Capable,
            thumbnailUrl,
            thumbnailWidth,
            thumbnailHeight,
            duration,
            videoData,
            permalinkUrl,
            videoType
        )
    }

    fun toBlockPost(): BlockPost {
        return BlockPost(
            blogName,
            id,
            blog,
            postUrl,
            timestamp,
            date,
            format,
            reblogKey,
            tags,
            isBookmarklet,
            isMobile,
            sourceUrl,
            sourceTitle,
            isLiked,
            state,
            totalPosts,
            anonymous,
            content,
            trail,
            layout,
            postAuthor,
            shortUrl,
            summary,
            isBlocksFormat,
            likedTimestamp,
            slug,
            noteCount,
            recommendedSource,
            recommendedColor,
            postAuthorIsAdult,
            isSubmission,
            canLike,
            canReblog,
            canSendInMessage,
            canReply,
            displayAvatar,
            followed,
            reblogData,
            rebloggedFromId,
            rebloggedFromUrl,
            rebloggedFromName,
            rebloggedFromTitle,
            rebloggedFromUuid,
            rebloggedFromCanMessage,
            rebloggedFromFollowing,
            rebloggedRootId,
            rebloggedRootUrl,
            rebloggedRootName,
            rebloggedRootTitle,
            rebloggedRootUuid,
            rebloggedRootCanMessage,
            rebloggedRootFollowing,
            notes,
            publishTime,
            queueState,
            shouldOpenInLegacy,
            muted,
            objectType,
            blogUUID,
            parentPostId,
            parentBlogUUID
        )
    }
}
