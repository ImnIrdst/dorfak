package com.imn.dorfak.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.imn.dorfak.databinding.ItemHomeAdapterBinding
import com.imn.dorfak.utils.screenSize

class HomeAdapter : RecyclerView.Adapter<HomeItemViewHolder>() {

    var data = listOf<String>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeItemViewHolder =
        HomeItemViewHolder(
            ItemHomeAdapterBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )


    override fun onBindViewHolder(holder: HomeItemViewHolder, position: Int) {
        holder.onBind(data[position])
    }

    override fun getItemCount() = data.size
}

class HomeItemViewHolder(
    private val binding: ItemHomeAdapterBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(url: String) {
        val detectedWidth = (binding.root.context.screenSize.x / 1.3).toInt()

        binding.root.layoutParams.width = detectedWidth
        Glide.with(binding.root.context)
            .load(url)
            .into(binding.imageView)
    }
}