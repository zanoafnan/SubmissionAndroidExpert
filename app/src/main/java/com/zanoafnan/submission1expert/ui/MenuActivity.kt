package com.zanoafnan.submission1expert.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zanoafnan.submission1expert.databinding.ActivityMenuBinding
 

 
class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}