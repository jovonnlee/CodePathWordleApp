package com.example.wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.wordle.FourLetterWordList.getRandomFourLetterWord

class MainActivity : AppCompatActivity() {
    var isCorrect = false
    private var wordToGuess = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        grabWord()
        buttonAction()

    }
    private fun grabWord(){
        wordToGuess = getRandomFourLetterWord()
    }
    private fun checkGuess(guess: String) : String {
        var result = ""
        val answer = findViewById<TextView>(R.id.answer)
        val hold = "Answer is $wordToGuess"
        answer.text = hold

        for (i in 0..3) {

            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        if (result == "OOOO"){
            isCorrect=true
        }
        return result
    }
    private fun reset(){

        val g1 = findViewById<TextView>(R.id.G1)
        val g2 = findViewById<TextView>(R.id.G2)
        val g3 = findViewById<TextView>(R.id.G3)
        val g4 = findViewById<TextView>(R.id.G4)
        val g1c = findViewById<TextView>(R.id.G1C)
        val g2c = findViewById<TextView>(R.id.G2C)
        val g3c = findViewById<TextView>(R.id.G3C)
        val g4c = findViewById<TextView>(R.id.G4C)
        val word1 = findViewById<TextView>(R.id.word1)
        val word2 = findViewById<TextView>(R.id.word2)
        val word3 = findViewById<TextView>(R.id.word3)
        val word4 = findViewById<TextView>(R.id.word4)
        val win = findViewById<TextView>(R.id.WIN)
        val answer = findViewById<TextView>(R.id.answer)
        val button = findViewById<Button>(R.id.button)
        val btnGuess = "Guess!"

        g1.visibility = View.INVISIBLE
        g2.visibility = View.INVISIBLE
        g3.visibility = View.INVISIBLE
        g4.visibility = View.INVISIBLE

        g1c.visibility = View.INVISIBLE
        g2c.visibility = View.INVISIBLE
        g3c.visibility = View.INVISIBLE
        g4c.visibility = View.INVISIBLE

        word1.visibility = View.INVISIBLE
        word2.visibility = View.INVISIBLE
        word3.visibility = View.INVISIBLE
        word4.visibility = View.INVISIBLE

        button.text = btnGuess
        isCorrect = false
        answer.visibility = View.INVISIBLE
        win.visibility = View.INVISIBLE
        grabWord()
        buttonAction()
    }
    private fun buttonAction(){

        val input = findViewById<EditText>(R.id.et_simple)
        val g1 = findViewById<TextView>(R.id.G1)
        val g2 = findViewById<TextView>(R.id.G2)
        val g3 = findViewById<TextView>(R.id.G3)
        val g4 = findViewById<TextView>(R.id.G4)
        val g1c = findViewById<TextView>(R.id.G1C)
        val g2c = findViewById<TextView>(R.id.G2C)
        val g3c = findViewById<TextView>(R.id.G3C)
        val g4c = findViewById<TextView>(R.id.G4C)
        val word1 = findViewById<TextView>(R.id.word1)
        val word2 = findViewById<TextView>(R.id.word2)
        val word3 = findViewById<TextView>(R.id.word3)
        val word4 = findViewById<TextView>(R.id.word4)
        val win = findViewById<TextView>(R.id.WIN)
        val answer = findViewById<TextView>(R.id.answer)
        val button = findViewById<Button>(R.id.button)
        val btnReset = "Reset!"
        var counter = 0


        button.setOnClickListener {
            counter++
            when (counter) {
                1 -> {
                    g1c.visibility = View.VISIBLE
                    g1.visibility = View.VISIBLE
                    g1c.text = checkGuess(input.text.toString().uppercase())
                    word1.text = input.text.toString().uppercase()
                    word1.visibility = View.VISIBLE
                }
                2 -> {
                    g2c.visibility = View.VISIBLE
                    g2c.text = checkGuess(input.text.toString().uppercase())
                    g2.visibility = View.VISIBLE
                    word2.text = input.text.toString().uppercase()
                    word2.visibility = View.VISIBLE
                }
                3 -> {
                    g3c.visibility = View.VISIBLE
                    g3c.text = checkGuess(input.text.toString().uppercase())
                    g3.visibility = View.VISIBLE
                    word3.text = input.text.toString().uppercase()
                    word3.visibility = View.VISIBLE
                }
                4 -> {
                    g4c.visibility = View.VISIBLE
                    g4c.text = checkGuess(input.text.toString().uppercase())
                    g4.visibility = View.VISIBLE
                    word4.text = input.text.toString().uppercase()
                    word4.visibility = View.VISIBLE
                }
            }
            if (counter == 4) {
                answer.visibility = View.VISIBLE
                button.text = btnReset
            }
            if (counter == 5) {
                reset()
            }
            if (isCorrect){
                answer.visibility = View.VISIBLE
                win.visibility = View.VISIBLE
                button.text = btnReset
                counter = 4
            }

            input.setText("")
        }
    }
}

