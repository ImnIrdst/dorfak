package com.imn.dorfak.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import com.imn.dorfak.databinding.FragmentHomeBinding
import com.imn.dorfak.ui.components.CenterZoomLayoutManager

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        binding = FragmentHomeBinding.inflate(inflater).apply {
            recyclerView.apply {
                adapter = HomeAdapter()
                layoutManager = CenterZoomLayoutManager(requireContext(), HORIZONTAL, false)
            }

        }
        homeViewModel.text.observe(viewLifecycleOwner, { getHomeAdapter().data = it })
        return binding.root
    }

    private fun getHomeAdapter() = binding.recyclerView.adapter as HomeAdapter
}