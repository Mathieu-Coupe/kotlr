package com.highthunder.kotlr.json.superwrapper

import com.highthunder.kotlr.json.wrapper.MediaWrapper
import com.highthunder.kotlr.types.Colors
import com.highthunder.kotlr.types.Media
import com.highthunder.kotlr.types.content.Attribution
import com.highthunder.kotlr.types.content.AudioContent
import com.highthunder.kotlr.types.content.ImageContent
import com.highthunder.kotlr.types.content.LinkContent
import com.highthunder.kotlr.types.content.PostContent
import com.highthunder.kotlr.types.content.TextContent
import com.highthunder.kotlr.types.content.TextFormat
import com.highthunder.kotlr.types.content.VideoContent
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * ContentAmalgamation - A class to hold every possible field for [PostContent] so that Mochi can
 * deserialize them.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 *
 * For all types of [PostContent]
 * @param type The type of content block that this is.
 *
 * [AudioContent]
 * @param provider The provider of the audio source, whether it's tumblr for native audio or a trusted third party.
 * @param url The URL to use for the audio block, if no [media] is present.
 * @param media The Media Object to use for the audio block, if no [url] is present.
 * @param title The title of the audio asset.
 * @param artist The artist of the audio asset.
 * @param album The album from which the audio asset originated.
 * @param poster An image media object to use as a "poster" for the audio track, usually album art.
 * @param embedHtml HTML code that could be used to embed this audio track into a webpage.
 * @param embedUrl A URL to the embeddable content to use as an iframe.
 * @param metadata Optional provider-specific metadata about the audio track.
 * @param attribution Optional attribution information about where the audio track came from.
 *
 * [ImageContent]
 * @param media An array of Media Objects which represent different available sizes of this image asset.
 * @param feedbackToken A feedback token to use when this image block is a GIF Search result.
 * @param colors Colors used in the image.
 * @param poster For GIFs, this is a single-frame "poster".
 * @param attribution See [Attribution] for details about these objects.
 *
 * [LinkContent]
 * @param url The URL to use for the link block.
 * @param title The title of where the link goes.
 * @param description The description of where the link goes.
 * @param author The author of the link's content.
 * @param siteName The name of the site being linked to.
 * @param displayUrl Supplied on NPF Post consumption, ignored during NPF Post creation.
 * @param poster An image media object to use as a "poster" for the link.
 *
 * [TextContent]
 * @param text The text to use inside this block.
 * @param subType The [SubType] of text block.
 * @param formatting A list of special formatting instructions.
 *
 * [VideoContent]
 * @param url The URL to use for the video block, if no media is present.
 * @param media The Media Object to use for the video block, if no url is present.
 * @param provider The provider of the video, whether it's tumblr for native video or a trusted third party.
 * @param embedHtml HTML code that could be used to embed this video into a webpage.
 * @param embedUrl A URL to the embeddable content to use as an iframe.
 * @param poster An image media object to use as a "poster" for the video, usually a single frame.
 * @param metadata Optional provider-specific metadata about the video.
 * @param attribution Optional attribution information about where the video came from.
 * @param canAutoPlayOnCellular Whether this video can be played on a cellular connection.
 * @param filmStrip TODO: Documentation
 * @param iframe TODO: Documentation
 */
@JsonClass(generateAdapter = true)
internal data class ContentAmalgamation constructor(

    // region PostContent

    @Json(name = "type")
    val type: String? = null,

    // endregion

    // region AudioContent

    @Json(name = "provider")
    val provider: String? = null,
    @Json(name = "url")
    val url: String? = null,
    @Json(name = "media")
    val media: MediaWrapper? = null,
    @Json(name = "title")
    val title: String? = null,
    @Json(name = "artist")
    val artist: String? = null,
    @Json(name = "album")
    val album: String? = null,
    @Json(name = "poster")
    val poster: List<Media>? = null,
    @Json(name = "embed_html")
    val embedHtml: String? = null,
    @Json(name = "embed_url")
    val embedUrl: String? = null,
    @Json(name = "metadata")
    val metadata: Any? = null,
    @Json(name = "attribution")
    val attribution: Attribution? = null,

    // endregion

    // region ImageContent

    @Json(name = "feedback_token")
    val feedbackToken: String? = null,
    @Json(name = "colors")
    val colors: Colors? = null,
    @Json(name = "alt_text")
    val altText: String? = null,

    // endregion

    // region LinkContent

    @Json(name = "description")
    val description: String? = null,
    @Json(name = "author")
    val author: String? = null,
    @Json(name = "site_name")
    val siteName: String? = null,
    @Json(name = "display_url")
    val displayUrl: String? = null,

    // endregion

    // region TextContent

    @Json(name = "text")
    val text: String? = null,
    @Json(name = "subtype")
    val subType: TextContent.SubType? = null,
    @Json(name = "formatting")
    val formatting: List<TextFormat>? = null,

    // endregion

    // region VideoContent

    @Json(name = "can_autoplay_on_cellular")
    val canAutoPlayOnCellular: Boolean? = null,
    @Json(name = "filmstrip")
    val filmStrip: MediaWrapper? = null,
    @Json(name = "embed_iframe")
    val iframe: Media? = null

    // endregion

) {
    constructor(content: AudioContent) : this(
        type = AudioContent.KEY,
        provider = content.provider,
        url = content.url,
        media = content.media?.let { MediaWrapper(singleMedia = it) },
        title = content.title,
        artist = content.artist,
        album = content.album,
        poster = content.poster,
        embedHtml = content.embedHtml,
        embedUrl = content.embedUrl,
        metadata = content.metadata,
        attribution = content.attribution
    )

    constructor(content: ImageContent) : this(
        type = ImageContent.KEY,
        media = content.media?.let { MediaWrapper(listMedia = it) },
        feedbackToken = content.feedbackToken,
        colors = content.colors,
        poster = content.poster,
        attribution = content.attribution
    )

    constructor(content: LinkContent) : this(
        type = LinkContent.KEY,
        url = content.url,
        title = content.title,
        description = content.description,
        author = content.author,
        siteName = content.siteName,
        displayUrl = content.displayUrl,
        poster = content.poster
    )

    constructor(content: TextContent) : this(
        type = TextContent.KEY,
        text = content.text,
        subType = content.subType,
        formatting = content.formatting
    )

    constructor(content: VideoContent) : this(
        type = VideoContent.KEY,
        url = content.url,
        media = content.media?.let { MediaWrapper(singleMedia = it) },
        provider = content.provider,
        embedHtml = content.embedHtml,
        embedUrl = content.embedUrl,
        poster = content.poster,
        metadata = content.metadata,
        attribution = content.attribution,
        canAutoPlayOnCellular = content.canAutoPlayOnCellular,
        filmStrip = content.filmStrip?.let { MediaWrapper(listMedia = it) },
        iframe = content.iframe
    )

    fun toAudioContent(): AudioContent = AudioContent(
        provider,
        url,
        media?.singleMedia,
        title,
        artist,
        album,
        poster,
        embedHtml,
        embedUrl,
        metadata,
        attribution
    )

    fun toImageContent(): ImageContent = ImageContent(
        media?.getAsList(),
        feedbackToken,
        colors,
        poster,
        attribution,
        altText
    )

    fun toLinkContent(): LinkContent = LinkContent(
        url,
        title,
        description,
        author,
        siteName,
        displayUrl,
        poster
    )

    fun toTextContent(): TextContent = TextContent(
        text,
        subType,
        formatting
    )

    fun toVideoContent(): VideoContent = VideoContent(
        url,
        media?.singleMedia,
        provider,
        embedHtml,
        embedUrl,
        poster,
        metadata,
        attribution,
        canAutoPlayOnCellular,
        filmStrip?.getAsList(),
        iframe
    )
}
