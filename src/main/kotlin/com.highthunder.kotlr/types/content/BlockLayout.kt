package com.highthunder.kotlr.types.content

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * BlockLayout - To lay out the blocks of a Post in a way that's different than the default
 * vertical stack, you can use the optional layout block alongside the content block array.
 * The layout block holds an array of layouts. Each layout object requires a type field,
 * just like content blocks.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
sealed class BlockLayout {
    abstract var type: String?

    /**
     * Vertical Layout - The default layout type, each content block should be placed below the
     * previous block.
     */
    @JsonClass(generateAdapter = true)
    class Vertical : BlockLayout() {
        companion object {
            const val KEY: String = "vertical"
        }

        override var type: String? = KEY
    }

    /**
     * Row Layout
     *
     * @param rows This is an array of the rows and block indices per row, for basic row layouts.
     * @param display This is an array of display objects per row, see [BlockLayout.Row.Display].
     */
    @JsonClass(generateAdapter = true)
    class Row constructor(
        @Json(name = "rows")
        var rows: List<List<Int>>? = null,
        @Json(name = "display")
        var display: List<Display>? = null
    ) : BlockLayout() {

        companion object {
            const val KEY: String = "rows"
        }

        override var type: String? = KEY

        /**
         *  TODO: Documentation
         *
         * @param blocks TODO: Documentation
         * @param mode TODO: Documentation
         */
        @JsonClass(generateAdapter = true)
        data class Display(
            @Json(name = "blocks")
            var blocks: List<Int>? = null,
            @Json(name = "mode")
            var mode: Mode? = Mode.Weighted()
        ) {

            /**
             *  TODO: Documentation
             */
            sealed class Mode {

                abstract var type: String?

                /**
                 *  TODO: Documentation
                 */
                @JsonClass(generateAdapter = true)
                class Weighted : Mode() {
                    companion object {
                        const val KEY: String = "weighted"
                    }

                    override var type: String? = KEY
                }

                /**
                 *  TODO: Documentation
                 */
                @JsonClass(generateAdapter = true)
                class Carousel : Mode() {
                    companion object {
                        const val KEY: String = "carousel"
                    }

                    override var type: String? = KEY
                }
            }
        }
    }

    /**
     * Condensed Layout
     *
     * @param blocks This is an array of block indices that are a part of the truncated version of the Post.
     */
    @JsonClass(generateAdapter = true)
    class Condensed constructor(
        @Json(name = "blocks")
        var blocks: List<Int>? = null
    ) : BlockLayout() {
        companion object {
            const val KEY: String = "condensed"
        }

        override var type: String? = KEY
    }

    /**
     * Ask Layout
     *
     * @param blocks This is an array of block indices that are a part of the ask content of the Post.
     * @param attribution If the ask is not anonymous, this will include information about the blog that submitted the ask.
     */
    @JsonClass(generateAdapter = true)
    class Ask constructor(
        @Json(name = "blocks")
        var blocks: List<Int>? = null,
        @Json(name = "attribution")
        var attribution: Attribution? = null
    ) : BlockLayout() {
        companion object {
            const val KEY: String = "ask"
        }

        override var type: String? = KEY
    }
}
