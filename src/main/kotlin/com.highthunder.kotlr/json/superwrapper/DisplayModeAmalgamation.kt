package com.highthunder.kotlr.json.superwrapper

import com.highthunder.kotlr.types.content.RowBlockLayout
import com.highthunder.kotlr.types.content.RowBlockLayout.Display.Mode.Carousel
import com.highthunder.kotlr.types.content.RowBlockLayout.Display.Mode.Weighted
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * DisplayModeAmalgamation - A class to hold every possible field for [RowBlockLayout.Display.Mode] so that Mochi can
 * deserialize them.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 *
 * @param type The type of this display mode.
 */
@JsonClass(generateAdapter = true)
internal data class DisplayModeAmalgamation(
    @Json(name = "type")
    val type: String? = null
) {
    constructor(mode: Weighted) : this(Weighted.KEY)
    constructor(mode: Carousel) : this(Carousel.KEY)

    fun toWeighted(): Weighted = Weighted()

    fun toCarousel(): Carousel = Carousel()
}
