package com.example.tvlimex.presentation.screens

import android.content.pm.ActivityInfo
import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tvlimex.R
import com.example.tvlimex.databinding.FragmentPlayerBinding
import com.example.tvlimex.domain.model.Channel
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.util.MimeTypes
import com.squareup.picasso.Picasso

class PlayerFragment : Fragment() {

    private lateinit var player: ExoPlayer
    private lateinit var binding: FragmentPlayerBinding
    private lateinit var nameChannel: TextView
    private lateinit var nameProgram: TextView
    private lateinit var imageIcon: ImageView
    private lateinit var backButton: ImageView
    private lateinit var qualityButton: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlayerBinding.inflate(inflater)
        with(binding.playerView) {
            nameChannel = this.findViewById(R.id.nameChannel)
            nameProgram = this.findViewById(R.id.nameProgram)
            imageIcon = this.findViewById(R.id.channelImage)
            backButton = this.findViewById(R.id.backButton)
            qualityButton = this.findViewById(R.id.qualityButton)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        requireActivity().window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        val channel = arguments?.get(KEY_CHANNEL_INFO) as Channel
        initialPlayer(channel)
        fillCustomPlayer(channel)
    }

    private fun initialPlayer(channel: Channel) {

        val context = requireContext()
        player = ExoPlayer.Builder(context)
            .build()
        binding.playerView.player = player
        val mediaItem = MediaItem.Builder()
            .setUri(channel.url)
            .setMimeType(MimeTypes.APPLICATION_M3U8)
            .build()

        player.playWhenReady = true
        player.setMediaItem(mediaItem)
        player.prepare()
        player.play()
    }

    private fun fillCustomPlayer(channel: Channel) {
        nameChannel.text = channel.nameRu
        nameProgram.text = channel.title
        Picasso.get()
            .load(channel.image)
            .error(R.drawable.ic_launcher_foreground)
            .into(imageIcon)

        backButton.setOnClickListener {
            findNavController().navigateUp()
        }

    }

    override fun onStop() {
        super.onStop()
        player.release()
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
    }
}