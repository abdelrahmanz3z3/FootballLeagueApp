package com.example.footballleagueapp.ui.competition

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.domain.model.CompetitionsItem
import com.example.footballleagueapp.databinding.ActivityCompetitionBinding
import com.example.footballleagueapp.ui.competition.adapter.CompetitionRecyclerAdapter
import com.example.footballleagueapp.ui.competition.viewmodel.CompetitionContract
import com.example.footballleagueapp.ui.competition.viewmodel.CompetitionViewModel
import com.example.footballleagueapp.ui.details.DetailsActivity
import com.facebook.shimmer.Shimmer
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CompetitionActivity : AppCompatActivity() {
    private var _binding: ActivityCompetitionBinding? = null
    private val binding get() = _binding
    private lateinit var viewModel: CompetitionViewModel
    private val recyclerAdapter = CompetitionRecyclerAdapter(listOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        viewModel.invokeActions(CompetitionContract.Action.LoadCompetition)
        observe()
    }

    private fun observe() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { state ->
                    renderViewStates(state)
                }
            }
        }
    }

    private fun renderViewStates(state: CompetitionContract.State) {
        when (state) {
            is CompetitionContract.State.Error -> {}
            is CompetitionContract.State.Loading -> {
                showShimmer()
            }

            is CompetitionContract.State.Success -> {
                hideShimmer()
                recyclerAdapter.bindNewList(state.data)
            }
        }
    }

    private fun showShimmer() {
        val shimmer = Shimmer.AlphaHighlightBuilder().setAutoStart(true).setBaseAlpha(0.25f)
            .setHighlightAlpha(0.75f).setDirection(Shimmer.Direction.LEFT_TO_RIGHT).build()
        binding?.competitionRecycler?.isVisible = false
        binding?.Shimmer?.setShimmer(shimmer)
        binding?.Shimmer?.startShimmer()
        binding?.Shimmer?.isVisible = true
    }

    private fun hideShimmer() {
        binding?.competitionRecycler?.isVisible = true
        binding?.Shimmer?.stopShimmer()
        binding?.Shimmer?.isVisible = false
    }

    private fun initViews() {
        _binding = ActivityCompetitionBinding.inflate(layoutInflater)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        )
        setContentView(binding?.root)
        viewModel = ViewModelProvider(this)[CompetitionViewModel::class.java]
        binding?.competitionRecycler?.adapter = recyclerAdapter
        recyclerAdapter.onItemClick =
            CompetitionRecyclerAdapter.OnItemClick { _, competition ->
                competition?.let {
                    navigateToDetailsActivity(it)
                }
            }
    }

    private fun navigateToDetailsActivity(competition: CompetitionsItem?) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("competition", competition)
        startActivity(intent)
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}