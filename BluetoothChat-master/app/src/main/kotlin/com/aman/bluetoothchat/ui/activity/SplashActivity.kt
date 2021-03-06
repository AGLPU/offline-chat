package com.aman.bluetoothchat.ui.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import com.aman.bluetoothchat.R
import com.aman.bluetoothchat.data.model.ProfileManagerImpl

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({

            val profileManager = ProfileManagerImpl(this)
            val nextScreen = if (profileManager.getUserName().isEmpty())
                ProfileActivity::class.java else ConversationsActivity::class.java
            val newIntent = Intent(this, nextScreen)

            if (intent.action == Intent.ACTION_SEND) {
                newIntent.action = Intent.ACTION_SEND
                newIntent.type = intent.type
                newIntent.putExtra(Intent.EXTRA_TEXT, intent.getStringExtra(Intent.EXTRA_TEXT))
                newIntent.putExtra(Intent.EXTRA_STREAM, intent.getParcelableExtra<Uri>(Intent.EXTRA_STREAM))
                newIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            }

            startActivity(newIntent)
            finish()

        }, 500)
    }
}
