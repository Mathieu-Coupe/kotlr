package com.highthunder.kotlr.json.wrapper

import com.highthunder.kotlr.types.Media
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonReader.Token.BEGIN_ARRAY
import com.squareup.moshi.JsonReader.Token.BEGIN_OBJECT
import com.squareup.moshi.JsonReader.Token.NULL
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson
import com.squareup.moshi.Types

/**
 * MediaWrapperJsonAdapter - An adapter to help Moshi convert [MediaWrapper] objects to and
 * from either a single [Media] object, or a list of them.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
internal class MediaWrapperJsonAdapter(moshi: Moshi) : JsonAdapter<MediaWrapper>() {

    private val mediaAdapter: JsonAdapter<Media?> =
        moshi.adapter(Media::class.java, kotlin.collections.emptySet(), null)

    private val listOfMediaAdapter: JsonAdapter<List<Media>> =
        moshi.adapter<List<Media>>(
            Types.newParameterizedType(List::class.java, Media::class.java),
            kotlin.collections.emptySet(),
            null
        )

    /**
     * TODO: Documentation
     */
    @FromJson
    override fun fromJson(reader: JsonReader): MediaWrapper? {
        return when (reader.peek()) {
            BEGIN_ARRAY -> MediaWrapper(listMedia = listOfMediaAdapter.fromJson(reader))
            BEGIN_OBJECT -> MediaWrapper(singleMedia = mediaAdapter.fromJson(reader))
            NULL -> null
            else -> throw JsonDataException("Expected a field of type List or Media but got ${reader.peek()}")
        }
    }

    /**
     * TODO: Documentation
     */
    @ToJson
    override fun toJson(writer: JsonWriter, value: MediaWrapper?) {
        when {
            value == null -> mediaAdapter.toJson(writer, null)
            value.singleMedia != null -> mediaAdapter.toJson(writer, value.singleMedia)
            value.listMedia != null && value.listMedia?.size != 0 -> listOfMediaAdapter.toJson(
                writer,
                value.listMedia ?: listOf()
            )
            else -> mediaAdapter.toJson(writer, null)
        }
    }
}
