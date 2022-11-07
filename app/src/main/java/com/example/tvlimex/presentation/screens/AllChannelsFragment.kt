package com.example.tvlimex.presentation.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.example.tvlimex.R
import com.example.tvlimex.databinding.FragmentAllChannelsBinding
import com.example.tvlimex.di.ViewModelFactory
import com.example.tvlimex.domain.model.Channel
import com.example.tvlimex.presentation.adapters.ChannelsRecyclerAdapter

const val KEY_CHANNEL_INFO = "ChannelInfo"

class AllChannelsFragment : Fragment() {

    private lateinit var binding: FragmentAllChannelsBinding
    private val viewModel: AllChannelsViewModel by viewModels { ViewModelFactory() }
    private val adapter = ChannelsRecyclerAdapter()
    private var listChannels = listOf<Channel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAllChannelsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerAllChannels.adapter = adapter
        setListenerAdapter()
        subscribe()
    }

    private fun setListenerAdapter() {
        adapter.onChannelItemClickListener = {
            val bundle = Bundle().apply { putParcelable(KEY_CHANNEL_INFO, it) }
            requireActivity().findNavController(R.id.nav_host)
                .navigate(R.id.playerFragment, bundle)
        }
        adapter.onStarClickListener = { viewModel.setListChannels(it) }
    }

    private fun subscribe() {
        lifecycleScope.launchWhenCreated {
            viewModel.localChannel.collect {
                if (it.isEmpty()) {
                    viewModel.getChannel()
                }
                adapter.channelList = it
                listChannels = it
            }
        }
    }

    fun searchChannel(text: String) {
        if (text.isEmpty()) {
            subscribe()
        } else {
            adapter.channelList = listChannels.filter { it.nameRu.lowercase() == text }
        }
    }
}