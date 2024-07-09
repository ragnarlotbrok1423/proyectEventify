package com.dev.eventify.presenters

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.dev.eventify.R

class CalificarProfActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.component_calificar_prof)

        val progressBar: ProgressBar = findViewById(R.id.circularProgressBar)
        val badIndicator: View = findViewById(R.id.bad)
        val mediumIndicator: View = findViewById(R.id.medium)
        val positIndicator: View = findViewById(R.id.posit)

        val progress = progressBar.progress

        when {
            progress < 33 -> {
                badIndicator.visibility = View.VISIBLE
                mediumIndicator.visibility = View.GONE
                positIndicator.visibility = View.GONE
            }

            progress in 33..65 -> {
                badIndicator.visibility = View.GONE
                mediumIndicator.visibility = View.VISIBLE
                positIndicator.visibility = View.GONE
            }

            else -> {
                badIndicator.visibility = View.GONE
                mediumIndicator.visibility = View.GONE
                positIndicator.visibility = View.VISIBLE
            }
        }
    }
}
