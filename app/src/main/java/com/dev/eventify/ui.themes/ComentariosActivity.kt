package com.dev.eventify.ui

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.dev.eventify.R

class ComentariosActivity : AppCompatActivity() {

    private lateinit var editTextComentario: EditText
    private lateinit var buttonSubmitComentario: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comentarios)

        editTextComentario = findViewById(R.id.editTextComentario)
        buttonSubmitComentario = findViewById(R.id.buttonSubmitComentario)

        buttonSubmitComentario.setOnClickListener {
             val comentario = editTextComentario.text.toString()
            if (comentario.isNotEmpty()) {
             }
        }
    }
}
