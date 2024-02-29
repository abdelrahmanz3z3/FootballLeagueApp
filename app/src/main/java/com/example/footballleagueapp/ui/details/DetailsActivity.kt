package com.example.footballleagueapp.ui.details

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.domain.model.CompetitionsItem
import com.example.footballleagueapp.common.Constants
import com.example.footballleagueapp.common.preventScreenShotsAndRecords
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
            intent.getParcelableExtra(
                Constants.parcelableCompetitionKey,
                CompetitionsItem::class.java
            )
        } else {
            intent.getParcelableExtra(Constants.parcelableCompetitionKey) as CompetitionsItem?

        }
        binding?.competition = competition
    }

    private fun initViews() {
        _binding = ActivityDetailsBinding.inflate(layoutInflater)
        preventScreenShotsAndRecords()
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