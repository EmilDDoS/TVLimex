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
import com.example.tvlimex.databinding.FragmentFavoriteChannelsBinding
import com.example.tvlimex.di.ViewModelFactory
import com.example.tvlimex.domain.model.Channel
import com.example.tvlimex.presentation.adapters.ChannelsRecyclerAdapter

class FavoriteChannelsFragment : Fragment() {

    private val adapter = ChannelsRecyclerAdapter()
    private lateinit var binding: FragmentFavoriteChannelsBinding
    val viewModel: FavoriteChannelsViewModel by viewModels { ViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteChannelsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerFavoriteChannels.adapter = adapter
        subscribe()
        setListenerAdapter()
    }

    private fun setListenerAdapter() {
        adapter.onChannelItemClickListener = {
            val bundle = Bundle().apply { putParcelable(KEY_CHANNEL_INFO, it) }
            requireActivity().findNavController(R.id.nav_host)
                .navigate(R.id.playerFragment, bundle)
        }

        adapter.onStarClickListener = { channel->
            viewModel.deleteChannelDb(channel.id)
        }
    }

    private fun subscribe() {
        lifecycleScope.launchWhenCreated {
            viewModel.getListDb().collect{
                adapter.channelList = it
            }
        }
    }
}