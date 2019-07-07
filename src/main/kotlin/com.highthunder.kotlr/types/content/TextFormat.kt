package com.highthunder.kotlr.types.content

import com.highthunder.kotlr.json.qualifier.HexColorOctothorpe
import com.highthunder.kotlr.types.Blog
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * TextFormat - In addition to subtypes at the Text block level, the text within a Text block
 * can have inline styles like bold, italic, external links, blog mentions, and colors.
 *
 * Inline formatting ranges (start and end) are zero-indexed and count each character as 1.
 * Ranges are inclusive at the start and exclusive at the end.
 *
 * A single unicode character is also treated as one character in this indexing, despite
 * possibly being multiple bytes. For example, ø and 🌳 are both counted as single characters in
 * NPF. However, a composite emoji like 👨‍👨‍👦 is five characters, as it is made up of
 * five unicode codepoints.
 *
 * Overlapping ranges of the same type should be combined or separated into non-overlapping ranges.
 * Overlapping ranges of different types should all be applied to the text, although it is up to
 * the Tumblr API to reconcile the ranges as needed to display correctly, just like
 * when nesting HTML.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 *
 * @param start The starting index of the formatting range (inclusive).
 * @param end The ending index of the formatting range (exclusive).
 */
sealed class TextFormat {
    abstract var start: Int?

    abstract var end: Int?

    abstract var type: String

    /**
     * TODO: Documentation
     */
    @JsonClass(generateAdapter = true)
    class Bold constructor(
        @Json(name = "start")
        override var start: Int? = null,
        @Json(name = "end")
        override var end: Int? = null
    ) : TextFormat() {
        companion object {
            const val KEY: String = "bold"
        }

        override var type: String = KEY
    }

    /**
     * TODO: Documentation
     */
    @JsonClass(generateAdapter = true)
    class Italic constructor(
        @Json(name = "start")
        override var start: Int? = null,
        @Json(name = "end")
        override var end: Int? = null
    ) : TextFormat() {
        companion object {
            const val KEY: String = "italic"
        }

        override var type: String = KEY
    }

    /**
     * TODO: Documentation
     */
    @JsonClass(generateAdapter = true)
    class StrikeThrough constructor(
        @Json(name = "start")
        override var start: Int? = null,
        @Json(name = "end")
        override var end: Int? = null
    ) : TextFormat() {
        companion object {
            const val KEY: String = "strikethrough"
        }

        override var type: String = KEY
    }

    /**
     * Link - TODO: Documentation
     *
     * @param url The link's URL!
     */
    @JsonClass(generateAdapter = true)
    class Link constructor(
        @Json(name = "start")
        override var start: Int? = null,
        @Json(name = "end")
        override var end: Int? = null,
        @Json(name = "url")
        var url: String? = null
    ) : TextFormat() {
        companion object {
            const val KEY: String = "link"
        }

        override var type: String = KEY
    }

    /**
     * Mention - TODO: Documentation
     *
     * @param blog An object with a uuid field, which is the mentioned blog's UUID.
     */
    @JsonClass(generateAdapter = true)
    class Mention constructor(
        @Json(name = "start")
        override var start: Int? = null,
        @Json(name = "end")
        override var end: Int? = null,
        @Json(name = "blog")
        var blog: Blog? = null
    ) : TextFormat() {
        companion object {
            const val KEY: String = "mention"
        }

        override var type: String = KEY
    }

    /**
     * Color - TODO: Documentation
     *
     * @param hex The color to use, in standard hex format, with leading '#'.
     */
    @JsonClass(generateAdapter = true)
    class Color constructor(
        @Json(name = "start")
        override var start: Int? = null,
        @Json(name = "end")
        override var end: Int? = null,
        @Json(name = "hex")
        @HexColorOctothorpe var hex: com.highthunder.kotlr.types.Color? = null
    ) : TextFormat() {
        companion object {
            const val KEY: String = "color"
        }

        override var type: String = KEY
    }

    /**
     * Size - TODO: Documentation
     *
     * @param size The text size for this particular range of text, one of 'small' or 'big'.
     */
    @JsonClass(generateAdapter = true)
    class Size constructor(
        @Json(name = "start")
        override var start: Int? = null,
        @Json(name = "end")
        override var end: Int? = null,
        @Json(name = "size")
        var size: Option? = null
    ) : TextFormat() {
        companion object {
            const val KEY: String = "size"
        }

        override var type: String = KEY

        /**
         * TODO: Documentation
         *
         * @param key TODO: Documentation
         */
        enum class Option(val key: String) {
            /**
             * TODO: Documentation
             */
            @Json(name = "small")
            Small("small"),
            /**
             * TODO: Documentation
             */
            @Json(name = "big")
            Big("big")
        }
    }
}
