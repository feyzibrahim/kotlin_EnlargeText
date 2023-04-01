package com.arstyn.enlargetext

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.google.android.gms.ads.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var text:String
    private lateinit var mAdView : AdView
    private lateinit var mInterstitialAd: InterstitialAd
    private var prvl: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-9184680471174773/9728524167"
        mInterstitialAd.loadAd(AdRequest.Builder().build())

        show_button.setOnClickListener {
            mInterstitialAd.show()
            text = text_to_display.text.toString()
            if (text.isNotEmpty()) {
                val intent = Intent(this, DisplayActivity::class.java)
                intent.putExtra("text", text)
                startActivity(intent)
            }
        }

        text_to_display.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                if (s != null) {
                    val len = s.length
                    if ((prvl < len) && (s.length == 10 || s.length == 21)) {
                        s.append("\n")
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                prvl = text_to_display.text.toString().length
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        })
    }
}
