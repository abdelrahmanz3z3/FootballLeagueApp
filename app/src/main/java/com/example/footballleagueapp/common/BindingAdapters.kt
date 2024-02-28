package com.example.footballleagueapp.common

import android.content.Intent
import android.net.Uri
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
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
        .into(imageView)

}

@BindingAdapter("app:LinkClicked")
fun clickLink(textView: TextView, url: String?) {
    url?.let {
        textView.setOnClickListener { text ->
            text.context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(it)))
        }
    }
}