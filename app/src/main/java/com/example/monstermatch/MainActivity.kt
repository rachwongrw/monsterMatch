package com.example.monstermatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.monstermatch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val monsters: List<Monster> = listOf(
        Monster(R.drawable.monster1_head, R.drawable.monster1_body, R.drawable.monster1_feet),
        Monster(R.drawable.monster2_head, R.drawable.monster2_body, R.drawable.monster2_feet),
        Monster(R.drawable.monster3_head, R.drawable.monster3_body, R.drawable.monster3_feet)
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
        binding.monsterHeadView.setImageResource(monsters.random().head)
        binding.monsterBodyView.setImageResource(monsters.random().body)
        binding.monsterFeetView.setImageResource(monsters.random().feet)
    }

    data class Monster (val head: Int, val body: Int, val feet: Int)
}