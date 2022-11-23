package com.sports.tech


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sports.tech.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var ind: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)


        setContentView(binding.root)

        binding.button1.setOnClickListener {
            startActivity(Intent(applicationContext,ListActivity::class.java).apply {
                putExtra("ind",1)
            })
        }
        binding.button2.setOnClickListener {
            startActivity(Intent(applicationContext,ListActivity::class.java).apply {
                putExtra("ind",2)
            })
        }
        binding.button3.setOnClickListener {
            startActivity(Intent(applicationContext,ListActivity::class.java).apply {
                putExtra("ind",3)
            })
        }
        binding.button4.setOnClickListener {
            startActivity(Intent(applicationContext,ListActivity::class.java).apply {
                putExtra("ind",4)
            })
        }
        binding.button5.setOnClickListener {
            startActivity(Intent(applicationContext,ListActivity::class.java).apply {
                putExtra("ind",5)
            })
        }
    }
}



