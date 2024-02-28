package com.example.footballleagueapp.common

import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.footballleagueapp.R
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerDrawable


@BindingAdapter("app:LoadImage")
fun loadImage(imageView: ImageView, link: Any?) {

    val shimmer = Shimmer.AlphaHighlightBuilder()
        .setDuration(1800)
        .setBaseAlpha(0.7f)
        .setHighlightAlpha(0.6f)
        .setDirection(Shimmer.Direction.LEFT_TO_RIGHT)
        .setAutoStart(true)
        .build()


    val shimmerDrawable = ShimmerDrawable().apply {
        setShimmer(shimmer)
    }
    shimmerDrawable.startShimmer()

    val url = link.toString()
    Glide
        .with(imageView.context)
        .load(url)
        .placeholder(shimmerDrawable)
        .error(R.drawable.soccer)
        .into(imageView)

}

@BindingAdapter("app:LinkClicked")
fun clickLink(view: View, url: String?) {
    view.setOnClickListener {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("$url"))
        it.context.startActivity(intent)
    }

}