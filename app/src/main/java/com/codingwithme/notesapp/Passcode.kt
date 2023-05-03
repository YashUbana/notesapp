package com.codingwithme.notesapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.hanks.passcodeview.PasscodeView

class Passcode : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passcode)

        var intent = getIntent()
        val pass = intent?.getStringExtra("password")
        val textView = findViewById<TextView>(R.id.locktxt).apply {
            text = pass
        }
        val passcodeView = findViewById<PasscodeView>(R.id.passcodeview)
        passcodeView.setPasscodeLength(5).setLocalPasscode("12345").setListener(object : PasscodeView.PasscodeViewListener{
            @Override
            override fun onFail() {
                Toast.makeText(this@Passcode,"Wrong Passcode",Toast.LENGTH_SHORT).show()
            }
            @Override
            override fun onSuccess(number: String?) {
                val intent = Intent(this@Passcode, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        });
    }
}