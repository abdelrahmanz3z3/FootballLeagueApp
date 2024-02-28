package com.example.footballleagueapp.ui.competition

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.footballleagueapp.databinding.ActivityCompetitionBinding
import com.example.footballleagueapp.datasource.model.CompetitionsItem
import com.example.footballleagueapp.ui.DetailsActivity
import com.example.footballleagueapp.ui.competition.adapter.CompetitionRecyclerAdapter
import com.example.footballleagueapp.ui.competition.viewmodel.CompetitionContract
import com.example.footballleagueapp.ui.competition.viewmodel.CompetitionViewModel
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
        setContentView(binding?.root)
        viewModel = ViewModelProvider(this)[CompetitionViewModel::class.java]
        binding?.competitionRecycler?.adapter = recyclerAdapter
        recyclerAdapter.onItemClick =
            CompetitionRecyclerAdapter.OnItemClick { position, competition ->
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


//    private fun initSplashScreen() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
//            installSplashScreen()
//            splashScreen.setOnExitAnimationListener { splashScreenView ->
//                val slideUp = ObjectAnimator.ofFloat(
//                    splashScreenView, View.TRANSLATION_Y, 0f, -splashScreenView.height.toFloat()
//                )
//                slideUp.interpolator = AnticipateInterpolator()
//                slideUp.duration = 1000L
//
//                slideUp.doOnEnd { splashScreenView.remove() }
//                slideUp.start()
//            }
//        } else {
//            setTheme(R.style.Theme_CompetitionActivity)
//        }
//    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}