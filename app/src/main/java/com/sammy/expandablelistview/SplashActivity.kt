package com.sammy.expandablelistview


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sammy.expandablelistview.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toDoList.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }


        binding.addList.setOnClickListener {
            startActivity(Intent(this, AddActivity::class.java))

        }
    }

}