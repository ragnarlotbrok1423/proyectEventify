package com.dev.eventify.presenters

import com.dev.eventify.entities.ProfesoresViewInterface
import androidx.lifecycle.lifecycleScope
import com.dev.eventify.entities.models.Valoraciones
import com.dev.eventify.entities.models.ValoracionesResponse
import com.dev.eventify.interactors.ProfesorXcalificacion
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfesorXcalificacion(private val interactor:ProfesorXcalificacion,
    private val view:ProfesoresViewInterface
    ) {
    private val job = Job()
    private val scope = CoroutineScope(Dispatchers.Main + job)

  fun obtenerValoraciones(profesorId: Int) {
        scope.launch {
            try {
               val response = interactor.obtenerValoraciones(profesorId)
                if (response.data != null) {
                    val valoraciones = response.data
                    val promedio = valoraciones.map { it.valoracion }.average()
                   view.mostrarValoraciones(valoraciones.map { it.copy(comentario =null) },promedio)
                }else {
                }

            } catch (e: Exception) {
                view.showError("Error: ${e.message}")
            }
        }
        }
    }

