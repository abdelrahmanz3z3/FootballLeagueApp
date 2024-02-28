package com.example.footballleagueapp.ui

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.footballleagueapp.databinding.ActivityDetailsBinding
import com.example.footballleagueapp.datasource.model.CompetitionsItem
import com.example.footballleagueapp.datasource.model.Winner

class DetailsActivity : AppCompatActivity() {
    private var _binding: ActivityDetailsBinding? = null
    private val binding get() = _binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        handelDataFromIntent()

    }

    private fun handelDataFromIntent() {
        val competition = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("competition", CompetitionsItem::class.java)
        } else {
            intent.getParcelableExtra("competition") as? CompetitionsItem

        }
        binding?.competition = competition
        binding?.content?.winner = competition?.currentSeason?.winner as? Winner
    }

    private fun initViews() {
        _binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.toolbar?.setOnClickListener {
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}