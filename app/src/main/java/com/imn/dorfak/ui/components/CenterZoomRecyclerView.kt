package com.imn.dorfak.ui.components

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView

class CenterZoomRecyclerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0,
    @Suppress("UNUSED_PARAMETER") @StyleRes defStyleRes: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {
    init {
        if (!isInEditMode) {
            setHasFixedSize(true)
            PagerSnapHelper().attachToRecyclerView(this)
        }
    }
}