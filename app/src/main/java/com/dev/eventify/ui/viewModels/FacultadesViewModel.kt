package com.dev.eventify.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.eventify.entities.apiService.EventifyService
import com.dev.eventify.entities.models.Facultades
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FacultadesViewModel: ViewModel() {

    private val _facultades = MutableLiveData<List<Facultades>>()
    val facultades: LiveData<List<Facultades>> get() = _facultades

    init {
        fetchFacultades()
    }

    private fun fetchFacultades() {
        viewModelScope.launch {
            try {
                val response = EventifyService.instance.getFacultad()
                _facultades.value = listOf(response)
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

//    EventifyService.instance.

}