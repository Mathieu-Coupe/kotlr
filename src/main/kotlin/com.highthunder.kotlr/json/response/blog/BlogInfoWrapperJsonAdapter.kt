package com.highthunder.kotlr.json.response.blog

import com.highthunder.kotlr.response.WrapperInterface
import com.highthunder.kotlr.response.type.blog.ResponseBlogInfo
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonReader.Token.BEGIN_ARRAY
import com.squareup.moshi.JsonReader.Token.BEGIN_OBJECT
import com.squareup.moshi.JsonReader.Token.NULL
import com.squareup.moshi.JsonReader.Token.STRING
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson
import com.squareup.moshi.Types

/**
 * BlogInfoWrapperJsonAdapter - TODO: Documentation
 *
 * @author highthunder
 * @since 10/25/18
 * @version 1.0.0
 */
internal class BlogInfoWrapperJsonAdapter(moshi: Moshi) : JsonAdapter<WrapperInterface<ResponseBlogInfo.Body>>() {

    private val stringAdapter: JsonAdapter<String?> =
        moshi.adapter(String::class.java, emptySet(), null)

    private val responseAdapter: JsonAdapter<ResponseBlogInfo.Body> =
        moshi.adapter<ResponseBlogInfo.Body>(ResponseBlogInfo.Body::class.java, emptySet(), null)

    private val listOfAnyAdapter: JsonAdapter<List<Any>> =
        moshi.adapter<List<Any>>(Types.newParameterizedType(List::class.java, Any::class.java), emptySet(), null)

    @FromJson
    override fun fromJson(reader: JsonReader): WrapperInterface<ResponseBlogInfo.Body> {
        return when (reader.peek()) {
            BEGIN_OBJECT -> ResponseBlogInfo.Wrapper(body = responseAdapter.fromJson(reader))
            STRING -> ResponseBlogInfo.Wrapper(error = stringAdapter.fromJson(reader))
            BEGIN_ARRAY -> ResponseBlogInfo.Wrapper(error = listOfAnyAdapter.fromJson(reader).toString())
            NULL -> ResponseBlogInfo.Wrapper()
            else -> throw JsonDataException("Expected a field of type List or String but got ${reader.peek()}")
        }
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: WrapperInterface<ResponseBlogInfo.Body>?) {
        if (value?.error != null) {
            stringAdapter.toJson(writer, value.error)
        } else {
            responseAdapter.toJson(writer, value?.body)
        }
    }
}
