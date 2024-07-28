package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionButton = findViewById<Button>(R.id.actionButton)
        val textView = findViewById<TextView>(R.id.titleTextView)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

        val viewModel = MainViewModel(LiveDataWrapper.Base(), Repository.Base())

        actionButton.setOnClickListener { viewModel.load() }

        viewModel.liveData.observe(this) { uiState ->
            uiState.action(actionButton, progressBar, textView)
        }
    }
}