package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val count = Count.Base(step = 2)
        val incrementButton = findViewById<Button>(R.id.incrementButton)
        val textView = findViewById<TextView>(R.id.countTextView)

        incrementButton.setOnClickListener {
            textView.text = count.increment(textView.text.toString())
        }
    }
}