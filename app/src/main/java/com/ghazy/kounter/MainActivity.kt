package com.ghazy.kounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.ghazy.kounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val viewModel: CounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.scoreA.observe(this) { scoreA ->
            binding.scoreA.text = scoreA.toString()
        }

        viewModel.scoreB.observe(this) { scoreB ->
            binding.scoreB.text = scoreB.toString()
        }

        viewModel.result.observe(this) { result ->
            binding.tvResult.text = result
        }

        binding.btnAddOneA.setOnClickListener {
            viewModel.addOne(true)
        }
        binding.btnAddOneB.setOnClickListener {
            viewModel.addOne(false)
        }
        binding.btnAddTwoA.setOnClickListener {
            viewModel.addTwo(true)
        }
        binding.btnAddTwoB.setOnClickListener {
            viewModel.addTwo(false)
        }
        binding.btnReset.setOnClickListener {
            viewModel.resetScore()
        }

    }
}