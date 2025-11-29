package com.example.flashcardapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val flashcardQuestion = findViewById<TextView>(R.id.flashcard_question)
        val flashcardAnswer = findViewById<TextView>(R.id.flashcard_answer)
        val buttonAdd = findViewById<ImageButton>(R.id.button_add)

        flashcardQuestion.setOnClickListener {
            flashcardQuestion.visibility = View.INVISIBLE
            flashcardAnswer.visibility = View.VISIBLE
        }

        flashcardAnswer.setOnClickListener {
            flashcardAnswer.visibility = View.INVISIBLE
            flashcardQuestion.visibility = View.VISIBLE
        }

        buttonAdd.setOnClickListener {
            val intent = Intent(this, AddCard::class.java)
            startActivityForResult(intent, 100)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {
            val newQuestion = data.getStringExtra("QUESTION_KEY")
            val newAnswer = data.getStringExtra("ANSWER_KEY")

            val flashcardQuestion = findViewById<TextView>(R.id.flashcard_question)
            val flashcardAnswer = findViewById<TextView>(R.id.flashcard_answer)

            flashcardQuestion.text = newQuestion
            flashcardAnswer.text = newAnswer
        }
    }
}