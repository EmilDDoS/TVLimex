package com.example.tvlimex.presentation.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.tvlimex.R
import com.example.tvlimex.databinding.FragmnetGeneralBinding
import com.example.tvlimex.di.ViewModelFactory
import com.example.tvlimex.presentation.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator


class GeneralFragment : Fragment() {

    private lateinit var binding: FragmnetGeneralBinding
    val viewModel: GeneralViewModel by viewModels { ViewModelFactory() }

    private val fragmentsList = listOf(
        AllChannelsFragment(),
        FavoriteChannelsFragment()
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmnetGeneralBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialViewPager()
    }

    private fun initialViewPager() {
        val titles = resources.getStringArray(R.array.tab_titles)
        val adapter = ViewPagerAdapter(requireActivity(), fragmentsList)
        binding.pager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.pager) {
                tabLayout, position -> tabLayout.text = titles[position]
        }.attach()
    }

}