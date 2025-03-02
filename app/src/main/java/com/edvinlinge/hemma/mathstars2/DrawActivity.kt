package com.edvinlinge.hemma.mathstars2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class DrawActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_draw)

        val dots = intent.getIntExtra("dots", 0)
        val skips = intent.getIntExtra("skips", 0)

        val drawView = findViewById<DrawView>(R.id.view)
        drawView.setDotsAndSkips(dots, skips)

        val button = findViewById<Button>(R.id.infoButton)

        button.setOnClickListener {
            drawView.showDetails(this)
        }
    }
}