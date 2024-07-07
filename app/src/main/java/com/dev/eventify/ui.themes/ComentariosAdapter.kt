package com.dev.eventify.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dev.eventify.R
import com.dev.eventify.entities.models.Comentario

class ComentariosAdapter : RecyclerView.Adapter<ComentariosAdapter.ComentarioViewHolder>() {

    private val comentarios = mutableListOf<Comentario>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComentarioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_comentario, parent, false)
        return ComentarioViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComentarioViewHolder, position: Int) {
        holder.bind(comentarios[position])
    }

    override fun getItemCount(): Int = comentarios.size

    fun setComentarios(comentarios: List<Comentario>) {
        this.comentarios.clear()
        this.comentarios.addAll(comentarios)
        notifyDataSetChanged()
    }

    fun addComentario(comentario: Comentario) {
        comentarios.add(comentario)
        notifyItemInserted(comentarios.size - 1)
    }

    class ComentarioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewComentario: TextView = itemView.findViewById(R.id.textViewComentario)
        private val textViewValoracion: TextView = itemView.findViewById(R.id.textViewValoracion)

        fun bind(comentario: Comentario) {
            textViewComentario.text = comentario.comentario
            textViewValoracion.text = "Valoración: ${comentario.valoracion}"
        }
    }
}
