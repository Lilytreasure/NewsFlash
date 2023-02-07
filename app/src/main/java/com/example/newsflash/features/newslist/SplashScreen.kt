package com.example.newsflash.features.newslist

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.newsflash.R

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {
private  lateinit var  textViewSplash: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        textViewSplash=findViewById(R.id.textSplash)
        textViewSplash.alpha=0f
        textViewSplash.animate().setDuration(2000).alpha(1f).withEndAction {

            val i =Intent(this, MainActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_in)
            finish()

        }

    }
}