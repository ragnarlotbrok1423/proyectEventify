package com.dev.eventify.presenters

import com.dev.eventify.entities.apiService.EventifyService
import com.dev.eventify.entities.models.Facultades
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

suspend fun fetchFacultades(onResult: (List<Facultades>) -> Unit) {
    val call = EventifyService.instance.getFacultades()
    call.enqueue(object : Callback<List<Facultades>> {


        override fun onResponse(
            call: Call<List<Facultades>>,
            response: Response<List<Facultades>>
        ) {
            if (response.isSuccessful) {
                response.body()?.let { onResult(it) }
            }
        }

        override fun onFailure(call: Call<List<Facultades>>, t: Throwable) {
            // Handle failure
        }
    })
}