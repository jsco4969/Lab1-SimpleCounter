package com.example.simplecounter

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.view.View

class MainActivity : AppCompatActivity() {
    private var counter = 0

    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.Button)

        val textView = findViewById<TextView>(R.id.TextView)


        // ... previous Button and Text creation code ...
        val upgradeButton = findViewById<Button>(R.id.UpgradeButton)


        button.setOnClickListener {
            // Toast.makeText(it.context, "Clicked Button!", Toast.LENGTH_SHORT).show()
            counter++
            textView.text = counter.toString()


            if (counter >= 100) {

                // Show upgrade button and set onClickListener
                upgradeButton.visibility = View.VISIBLE
                upgradeButton.setOnClickListener {
                    button.text = "Add 2"

                    // Update original button to add 2 instead of `
                    button.setOnClickListener {
                        counter += 2
                        textView.text = counter.toString()
                    }

                    // Hide upgrade button again
                    upgradeButton.visibility = View.INVISIBLE
                }
            }
        }
    }
}