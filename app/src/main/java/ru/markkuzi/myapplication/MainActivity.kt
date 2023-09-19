package ru.markkuzi.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val mStartActivityForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult(),
        ActivityResultCallback {
            val mainTextView = findViewById<TextView>(R.id.main_text_view)
            if (it.resultCode == Activity.RESULT_OK) {
                val intent = it.data
                val text = intent?.getStringExtra("SECOND")
                mainTextView.text = text
            } else
                mainTextView.text = "Error"
        })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainButton = findViewById<Button>(R.id.main_button)
        val mainEditText = findViewById<EditText>(R.id.main_edit_text)

        mainButton.setOnClickListener {
            val putText = mainEditText.text.toString()
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("MAIN", putText)
            }
            mStartActivityForResult.launch(intent)
        }
    }
}