package com.imn.dorfak.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import com.imn.dorfak.databinding.FragmentHomeBinding

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
                layoutManager = LinearLayoutManager(requireContext(), HORIZONTAL, false)
            }

        }
        homeViewModel.text.observe(viewLifecycleOwner, { getAdapter().data = it })
        return binding.root
    }

    private fun getAdapter() = binding.recyclerView.adapter as HomeAdapter
}