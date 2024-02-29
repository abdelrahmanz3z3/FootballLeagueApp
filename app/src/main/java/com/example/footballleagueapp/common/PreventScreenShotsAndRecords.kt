package com.example.footballleagueapp.common

import android.app.Activity
import android.view.WindowManager


fun Activity.preventScreenShotsAndRecords() {
    window.setFlags(
        WindowManager.LayoutParams.FLAG_SECURE,
        WindowManager.LayoutParams.FLAG_SECURE
    )

}