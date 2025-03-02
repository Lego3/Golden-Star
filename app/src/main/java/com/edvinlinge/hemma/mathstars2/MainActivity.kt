package com.edvinlinge.hemma.mathstars2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.drawLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonRender = findViewById<Button>(R.id.buttonRender)

        val dots = findViewById<EditText>(R.id.editNumberDots)
        val skips = findViewById<EditText>(R.id.editNumberSkips)

        buttonRender.setOnClickListener {
            val dotNumber = dots.text.toString().toIntOrNull() ?: 5
            val skipNumber = skips.text.toString().toIntOrNull() ?: 2
            val intent = Intent(this, DrawActivity::class.java).apply {
                putExtra("dots", dotNumber)
                putExtra("skips", skipNumber)
            }
            startActivity(intent)
        }

        val buttonHelp = findViewById<Button>(R.id.buttonHelp)

        buttonHelp.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle(R.string.help)
                .setMessage(getString(R.string.help_details))
                .setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }
}