package me.tmbmnadim.dhaka_unleashed.view_model

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import me.tmbmnadim.dhaka_unleashed.data.DhakaPlacesSource
import me.tmbmnadim.dhaka_unleashed.models.DhakaPlace

class DhakaPlacesViewModel : ViewModel() {
    private var _uiState = MutableStateFlow(DhakaPlacesState())
    var uiState: StateFlow<DhakaPlacesState> = _uiState

    init {
        getDhakaPlacesList()
    }

    fun getDhakaPlacesList() {
        val places = DhakaPlacesSource.places
        _uiState.update {
            it.copy(places = places, selectedPlace = places[0])
        }
    }

    fun updateDetailsScreenStates(place: DhakaPlace) {
        _uiState.update {
            it.copy(
                selectedPlace = place,
                isShowingHomepage = false
            )
        }
    }

    fun resetHomeScreenStates() {
        _uiState.update {
            it.copy(
                selectedPlace = it.places[0],
                isShowingHomepage = true
            )
        }
    }
}