package com.example.footballleagueapp.ui.details

import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.domain.model.CompetitionsItem
import com.example.footballleagueapp.databinding.ActivityDetailsBinding

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
            intent.getParcelableExtra("competition") as CompetitionsItem?

        }
        binding?.competition = competition
        binding?.winner = competition?.currentSeason?.winner
    }

    private fun initViews() {
        _binding = ActivityDetailsBinding.inflate(layoutInflater)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        )
        setContentView(binding?.root)
        binding?.toolbar?.setNavigationOnClickListener {
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}