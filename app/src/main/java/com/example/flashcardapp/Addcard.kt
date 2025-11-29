package com.example.flashcardapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AddCard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_addcard)

        val editQuestion = findViewById<EditText>(R.id.edit_question)
        val editAnswer = findViewById<EditText>(R.id.edit_answer)
        val saveButton = findViewById<Button>(R.id.save_button)
        val backButton = findViewById<Button>(R.id.back_button)

        saveButton.setOnClickListener {
            val questionText = editQuestion.text.toString()
            val answerText = editAnswer.text.toString()

            val data = Intent()
            data.putExtra("QUESTION_KEY", questionText)
            data.putExtra("ANSWER_KEY", answerText)

            setResult(Activity.RESULT_OK, data)
            finish()
        }

        backButton.setOnClickListener {
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}