package com.example.appcomadmob

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appcomadmob.databinding.ActivityMainBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //Inicialização o admob
        MobileAds.initialize(this)

        val request = AdRequest.Builder().build()
        binding.adView.loadAd( request )

    }


}