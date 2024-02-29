package com.example.footballleagueapp.ui.competitions

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.domain.model.CompetitionsItem
import com.example.footballleagueapp.common.Constants
import com.example.footballleagueapp.common.preventScreenShotsAndRecords
import com.example.footballleagueapp.databinding.ActivityCompetitionBinding
import com.example.footballleagueapp.ui.competitions.adapter.CompetitionRecyclerAdapter
import com.example.footballleagueapp.ui.competitions.viewmodel.CompetitionContract
import com.example.footballleagueapp.ui.competitions.viewmodel.CompetitionViewModel
import com.example.footballleagueapp.ui.details.DetailsActivity
import com.facebook.shimmer.Shimmer
import com.google.android.material.snackbar.Snackbar
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

    private fun initViews() {
        _binding = ActivityCompetitionBinding.inflate(layoutInflater)
        preventScreenShotsAndRecords()
        setContentView(binding?.root)

        viewModel = ViewModelProvider(this)[CompetitionViewModel::class.java]

        binding?.competitionRecycler?.adapter = recyclerAdapter
        recyclerAdapter.onItemClick =
            CompetitionRecyclerAdapter.OnItemClick { _, competition ->
                competition?.let {
                    viewModel.invokeActions(CompetitionContract.Action.GotoDetailsActivity(it))
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


    private fun observe() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect(::renderViewStates)
            }
        }
        viewModel.event.observe(this, ::handelEvents)
    }

    private fun handelEvents(event: CompetitionContract.Event) {
        when (event) {
            is CompetitionContract.Event.CompetitionItemClicked -> {
                navigateToDetailsActivity(event.item)
            }
        }
    }

    private fun renderViewStates(state: CompetitionContract.State) {
        when (state) {
            is CompetitionContract.State.Error -> {
                Snackbar.make(this, binding?.root!!, state.error, Snackbar.LENGTH_SHORT).show()
            }

            is CompetitionContract.State.Loading -> {
                showShimmer()
            }

            is CompetitionContract.State.Success -> {
                hideShimmer()
                recyclerAdapter.bindNewList(state.data)
            }
        }
    }



    private fun navigateToDetailsActivity(competition: CompetitionsItem?) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(Constants.parcelableCompetitionKey, competition)
        startActivity(intent)
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}