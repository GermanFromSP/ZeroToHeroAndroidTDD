package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.parcelize.Parcelize

private const val KEY = "key"

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var layout: LinearLayout
    private lateinit var removeButton: Button
    private var state: State = State.Initial

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        removeButton = findViewById(R.id.removeButton)
        textView = findViewById(R.id.titleTextView)
        layout = findViewById(R.id.rootLayout)

        removeButton.setOnClickListener {
            state = State.Remove
            state.apply(layout, textView, removeButton)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY, state)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        state = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            savedInstanceState.getParcelable(KEY, State::class.java) as State
        } else {
            savedInstanceState.getSerializable(KEY) as State
        }
        state.apply(layout, textView, removeButton)
    }
}

interface State : Parcelable {

    fun apply(linearLayout: LinearLayout, textView: TextView, button: Button)

    @Parcelize
    data object Initial : State {
        override fun apply(linearLayout: LinearLayout, textView: TextView, button: Button) = Unit
    }

    @Parcelize
    data object Remove : State {

        override fun apply(linearLayout: LinearLayout, textView: TextView, button: Button) {
            linearLayout.removeView(textView)
            button.isEnabled = false
        }
    }

}