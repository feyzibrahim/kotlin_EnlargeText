package com.arstyn.enlargetext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_display.*

class DisplayActivity : AppCompatActivity() {

    lateinit var text: String

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_display)

        text = intent.getStringExtra("text")!!

        when (text.length) {
            1 -> displayText.textSize = 300F
            2 -> displayText.textSize = 300F
            3 -> displayText.textSize = 300F
            4 -> displayText.textSize = 250F
            5 -> displayText.textSize = 200F
            6 -> displayText.textSize = 170F
            7 -> displayText.textSize = 140F
            8 -> displayText.textSize = 125F
            9 -> displayText.textSize = 115F
            10 -> displayText.textSize = 100F
        }
        displayText.text = text
    }
}
