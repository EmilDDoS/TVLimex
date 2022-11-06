package com.example.tvlimex.presentation.screens

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tvlimex.databinding.FragmentPlayerBinding
import com.example.tvlimex.domain.model.Channel
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.util.MimeTypes

class PlayerFragment : Fragment() {

    private lateinit var player: ExoPlayer
    private lateinit var binding: FragmentPlayerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlayerBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        initialPlayer()
    }

    private fun initialPlayer() {
        val arg = arguments?.get(KEY_CHANNEL_INFO) as Channel
        player = ExoPlayer.Builder(requireContext())
            .build()
        binding.playerView.player = player
        val mediaItem = MediaItem.Builder()
            .setUri(arg.url)
            .setMimeType(MimeTypes.APPLICATION_M3U8)
            .build()
        player.playWhenReady = true
        player.setMediaItem(mediaItem)
        player.prepare()
        player.play()
    }

    override fun onStop() {
        super.onStop()
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
    }
}