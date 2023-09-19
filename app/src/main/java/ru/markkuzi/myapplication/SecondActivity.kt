package ru.markkuzi.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val text = intent.getStringExtra("MAIN")

        val secondTextView = findViewById<TextView>(R.id.second_text_view)
        val secondButton = findViewById<Button>(R.id.second_button)
        val secondEditText = findViewById<EditText>(R.id.second_edit_text)

        secondTextView.text = text

        secondButton.setOnClickListener {
            val putText = secondEditText.text.toString()
            val answerIntent = Intent().apply {
                putExtra("SECOND", putText)
            }
            setResult(RESULT_OK, answerIntent)
            finish()
        }
    }
}