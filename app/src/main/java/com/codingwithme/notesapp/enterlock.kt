package com.codingwithme.notesapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_enterlock.*


class enterlock : AppCompatActivity() {
    var password = ""
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enterlock)





        var lockedit = findViewById<EditText>(R.id.lockedit)
        val lockbtn = findViewById<Button>(R.id.lockbtn)
        var locktxt = findViewById<TextView>(R.id.locktxt)
        loadData()

        lockbtn.setOnClickListener{
            saveData()
            val intent1 = Intent(this, Passcode::class.java)
            intent1.putExtra("password", locktxt.text.toString())
        }
    }


        private fun saveData() {
            val insertedText: String = lockedit.text.toString()
            locktxt.text = insertedText

            val sharedPreferences = getSharedPreferences("pass", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.apply {
                putString("STRING_KEY", insertedText)
            }.apply()
            Toast.makeText(this, "Passcode Saved", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

         fun loadData() {

            val sharedPreferences = getSharedPreferences("pass", Context.MODE_PRIVATE)
            val savedString = sharedPreferences.getString("STRING_KEY", null)

            if (savedString != null) {
                locktxt.text = savedString
                val intent1 = Intent(this, Passcode::class.java)
                intent1.putExtra("Extra_TEXT", password)
            }
        }
}