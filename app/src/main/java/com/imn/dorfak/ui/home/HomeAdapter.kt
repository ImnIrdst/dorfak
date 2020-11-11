package com.imn.dorfak.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.imn.dorfak.databinding.ItemHomeAdapterBinding

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

    fun onBind(text: String) {
        binding.textView.text = text
    }
}