package com.utkukiziltas.proje.Activity

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.utkukiziltas.proje.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            findViewById<ImageView>(R.id.ivUtku).visibility = View.VISIBLE
        }, 1000)

        if(internetKontrol()) {
            Handler().postDelayed({
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }, 2000)
        }
        else {
            Toast.makeText(this, "İnternet Bağlantınızı Kontrol Ediniz", Toast.LENGTH_SHORT).show()
            finish()
        }

    }


    private fun internetKontrol(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetInfo = connectivityManager.activeNetworkInfo;
        if (activeNetInfo != null && activeNetInfo.isConnectedOrConnecting) {
            return true
        }
        return false
    }
}