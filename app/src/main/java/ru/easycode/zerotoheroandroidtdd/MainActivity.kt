package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonChange = findViewById<Button>(R.id.changeButton)
        val textView = findViewById<TextView>(R.id.titleTextView)

        buttonChange.setOnClickListener {
            textView.text = "I am an Android Developer!"
        }
    }
}