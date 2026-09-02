package me.tmbmnadim.dhaka_unleashed.view_model

import me.tmbmnadim.dhaka_unleashed.models.DhakaPlace

data class DhakaPlacesState(
    val isShowingHomepage: Boolean = true,
    val places: List<DhakaPlace> = listOf(),
    val selectedPlace: DhakaPlace? = null,
) {
    fun copy(
        isHomepageShowing: Boolean?,
        places: List<DhakaPlace>?,
        selectedPlace: DhakaPlace?
    ): DhakaPlacesState {
        return DhakaPlacesState(
            isShowingHomepage = isHomepageShowing ?: this.isShowingHomepage,
            places = places ?: this.places,
            selectedPlace = selectedPlace ?: this.selectedPlace
        )
    }
}