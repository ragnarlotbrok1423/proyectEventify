package com.dev.eventify.presenters

import com.dev.eventify.entities.ValoracionViewInterface
import com.dev.eventify.entities.ValoracionesInteractorInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ValoracionPresenter (private val view: ValoracionViewInterface,
    private val interactor: ValoracionesInteractorInterface
    ) {

    suspend fun Valoracion(valoracion:Int, comenteario:String?, estudianteId:Int, profesorId:Int){
        GlobalScope.launch (Dispatchers.Main) {
            val valoracionResult= interactor.createValoration(valoracion,comenteario)
            if (valoracionResult.error == null){
                val valoracionId= valoracionResult.data ?: return@launch
                val incognitePost= interactor.incognitePost(estudianteId, profesorId,valoracionId)
                if (incognitePost.error == null){
                    view.showSuccess()
                }else{
                    view.showError("algo ha salido mal")
                }
            }else{
                view.showError("algo ha salido mal")
            }
        }
        }
}