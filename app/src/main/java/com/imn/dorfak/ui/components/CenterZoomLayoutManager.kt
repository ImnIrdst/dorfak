package com.imn.dorfak.ui.components

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.abs
import kotlin.math.min

class CenterZoomLayoutManager : LinearLayoutManager {

    private val mZoomAmount = 0.50f

    private val smoothScroller: CenterSmoothScroller

    constructor(context: Context) : super(context) {
        smoothScroller = CenterSmoothScroller(context)
    }

    constructor(context: Context, orientation: Int, reverseLayout: Boolean) :
            super(context, orientation, reverseLayout) {
        smoothScroller = CenterSmoothScroller(context)
    }

    override fun scrollHorizontallyBy(
        dx: Int,
        recycler: RecyclerView.Recycler?,
        state: RecyclerView.State?
    ): Int {
        if (orientation == HORIZONTAL) {
            val scrolled = super.scrollHorizontallyBy(dx, recycler, state)

            val d0 = 0f
            val midpoint = width / 2f
            val s0 = 1.0f + mZoomAmount
            val s1 = 1.0f
            for (i in 0 until childCount) {
                val child = getChildAt(i)
                val childMidpoint = (getDecoratedRight(child!!) + getDecoratedLeft(child)) / 2f
                val d = min(midpoint, abs(midpoint - childMidpoint))
                val scale = s1 + (s0 - s1) * (d - d0) / (midpoint - d0)

                getChildImageView(child).apply {
                    scaleX = scale
                    scaleY = scale
                }
            }
            return scrolled
        } else {
            return 0
        }
    }

    private fun getChildImageView(child: View) =
        ((child as ViewGroup).getChildAt(0) as ViewGroup).getChildAt(0)
}

class CenterSmoothScroller(context: Context) : LinearSmoothScroller(context) {

    override fun calculateDtToFit(
        viewStart: Int,
        viewEnd: Int,
        boxStart: Int,
        boxEnd: Int,
        snapPreference: Int
    ) = boxStart + (boxEnd - boxStart) / 2 - (viewStart + (viewEnd - viewStart) / 2)
}