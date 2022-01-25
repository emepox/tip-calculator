package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.tiptime.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        val view = binding.root
        setContentView(view)

        binding.btnCalculate.setOnClickListener {
            calculateTips()
        }
    }

    private fun calculateTips() {

        val cost = binding.etPrice.text.toString().toDouble()
        val percent = when (binding.rgSelect.checkedRadioButtonId) {
            R.id.rb_amazing -> 0.2
            R.id.rb_good -> 0.18
            else -> 0.15
        }

        val tip = cost * percent

        binding.tvAmount.text = if (binding.swRound.isChecked) {
            getString(R.string.tip_amount, tip.roundToInt().toString())        } else {
            getString(R.string.tip_amount, tip.toString())

        }
    }
}