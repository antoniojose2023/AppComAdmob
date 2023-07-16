package com.example.appcomadmob

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appcomadmob.databinding.ActivityMainBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var mInterstitialAd : InterstitialAd
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //Inicialização o admob
        MobileAds.initialize(this)

        //Implementando a propaganda com banner
        val request = AdRequest.Builder().build()
        binding.adView.loadAd( request )

        //Configurar o intersticial
        configIntersticial()

        binding.btAbrirIntesticial.setOnClickListener {
              startActivity(Intent(this, SegundaActivity::class.java))
              //exibir intersticial
              mInterstitialAd.show(this)
        }

    }

    fun configIntersticial(){
        //Implementando a propaganda de tela inteira
        val adRequest = AdRequest.Builder().build()
        InterstitialAd.load(this, "ca-app-pub-3940256099942544/1033173712", adRequest, object :
            InterstitialAdLoadCallback() {

            override fun onAdFailedToLoad(error: LoadAdError) {
                super.onAdFailedToLoad(error)
            }

            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                mInterstitialAd = interstitialAd
                super.onAdLoaded(interstitialAd)
            }
        })
    }

}