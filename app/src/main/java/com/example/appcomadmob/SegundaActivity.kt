package com.example.appcomadmob

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appcomadmob.databinding.ActivitySegundaBinding

class SegundaActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySegundaBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}