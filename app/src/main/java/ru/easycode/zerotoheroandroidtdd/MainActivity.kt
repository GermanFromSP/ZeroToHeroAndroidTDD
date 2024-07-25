package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.transition.Visibility

private const val KEY = "key"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val hideButton = findViewById<Button>(R.id.hideButton)
        val textView = findViewById<TextView>(R.id.titleTextView)

        hideButton.setOnClickListener {
            textView.visibility = View.INVISIBLE
        }

        savedInstanceState?.let {
            textView.visibility = savedInstanceState.getInt(KEY)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY, View.INVISIBLE)
    }
}