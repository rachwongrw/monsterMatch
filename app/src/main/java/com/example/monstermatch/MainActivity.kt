package com.example.monstermatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.monstermatch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val heads: List<Int> = listOf(
        R.drawable.monster1_head,
        R.drawable.monster2_head,
        R.drawable.monster3_head
    )

    private val bodies: List<Int> = listOf(
        R.drawable.monster1_body,
        R.drawable.monster2_body,
        R.drawable.monster3_body
    )

    private val feet: List<Int> = listOf(
        R.drawable.monster1_feet,
        R.drawable.monster2_feet,
        R.drawable.monster3_feet
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        shuffleMonsters()
        binding.shuffleButton.setOnClickListener {
            shuffleMonsters()
        }
    }

    private fun shuffleMonsters() {
        binding.monsterHeadView.setImageResource(heads.random())
        binding.monsterBodyView.setImageResource(bodies.random())
        binding.monsterFeetView.setImageResource(feet.random())
    }
}