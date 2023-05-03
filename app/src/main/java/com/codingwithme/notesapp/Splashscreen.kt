package com.codingwithme.notesapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class Splashscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {12345
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        val sharedPref = getSharedPreferences("myAppPrefs", Context.MODE_PRIVATE)
        val hasRunBefore = sharedPref.getBoolean("hasRunBefore", false)


        if (!hasRunBefore) {
            // launch activity here
            startActivity(Intent(this, enterlock::class.java))
            // set hasRunBefore to true
            with (sharedPref.edit()) {
                putBoolean("hasRunBefore", true)

                apply()
            }
        }



        supportActionBar?.hide()

        if(hasRunBefore) {
            val handler = Handler(Looper.getMainLooper())
            handler.postDelayed({

                val intent = Intent(this, Passcode::class.java)
                startActivity(intent)
                finish()
            }, 3000)
        }
    }
}