package com.imn.dorfak.utils

import android.content.Context
import android.graphics.Point
import android.view.WindowManager

val Context.screenSize: Point
    get() = Point().also {
        (getSystemService(Context.WINDOW_SERVICE) as? WindowManager)?.defaultDisplay?.getSize(it)
    }