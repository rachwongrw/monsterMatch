package com.example.monstermatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.monstermatch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val monsters: List<Monster> = listOf(
        Monster(1,"Barry", R.drawable.monster1_head, R.drawable.monster1_body, R.drawable.monster1_feet),
        Monster(2,"Garry", R.drawable.monster2_head, R.drawable.monster2_body, R.drawable.monster2_feet),
        Monster(3, "Larry", R.drawable.monster3_head, R.drawable.monster3_body, R.drawable.monster3_feet)
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
        var head = monsters.random()
        var body = monsters.random()
        var feet = monsters.random()

        binding.monsterHeadView.setImageResource(head.head)
        binding.monsterBodyView.setImageResource(body.body)
        binding.monsterFeetView.setImageResource(feet.feet)

        var headId = head.id
        var bodyId = body.id
        var feetId = feet.id

        if (headId === bodyId && bodyId === feetId) {
            binding.msgText.text = "You match " + head.name + "!"
        } else {
            binding.msgText.text = ""
        }


    }

    data class Monster (val id: Int, val name: String, val head: Int, val body: Int, val feet: Int)
}