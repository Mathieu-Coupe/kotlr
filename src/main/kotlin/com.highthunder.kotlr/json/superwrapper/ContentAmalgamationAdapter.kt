package com.highthunder.kotlr.json.superwrapper

import com.highthunder.kotlr.types.content.AudioContent
import com.highthunder.kotlr.types.content.ImageContent
import com.highthunder.kotlr.types.content.LinkContent
import com.highthunder.kotlr.types.content.PostContent
import com.highthunder.kotlr.types.content.TextContent
import com.highthunder.kotlr.types.content.VideoContent
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.ToJson

/**
 * ContentAmalgamationAdapter - An adapter to help Moshi convert [ContentAmalgamation] objects to and
 * from individual subclasses of [PostContent].
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
internal class ContentAmalgamationAdapter {
    @FromJson
    fun toContent(input: ContentAmalgamation): PostContent {
        return when (input.type) {
            AudioContent.KEY -> input.toAudioContent()
            ImageContent.KEY -> input.toImageContent()
            LinkContent.KEY -> input.toLinkContent()
            TextContent.KEY -> input.toTextContent()
            VideoContent.KEY -> input.toVideoContent()
            else -> throw JsonDataException("Expected a field of type ContentAmalgamation but got $input")
        }
    }

    @ToJson
    fun fromContent(input: PostContent): ContentAmalgamation {
        return when (input) {
            is AudioContent -> ContentAmalgamation(input)
            is ImageContent -> ContentAmalgamation(input)
            is LinkContent -> ContentAmalgamation(input)
            is TextContent -> ContentAmalgamation(input)
            is VideoContent -> ContentAmalgamation(input)
        }
    }
}
