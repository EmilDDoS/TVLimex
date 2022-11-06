package com.example.tvlimex.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.*
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.tvlimex.R
import com.example.tvlimex.databinding.ChannelItemBinding
import com.example.tvlimex.domain.model.Channel
import com.squareup.picasso.Picasso

class ChannelsRecyclerAdapter : RecyclerView.Adapter<ChannelsRecyclerAdapter.ChannelsViewHolder>() {

    var channelList = listOf<Channel>()
        set(value) {
            val callback = ChannelsDiffUtil(channelList, value)
            val diffResult = DiffUtil.calculateDiff(callback)
            diffResult.dispatchUpdatesTo(this)
            field = value
        }

    var onChannelItemClickListener: ((Channel) -> Unit)? = null

    var onStarClickListener: ((List<Channel>) -> Unit)? = null

    class ChannelsViewHolder(view: ChannelItemBinding) : RecyclerView.ViewHolder(view.root) {
        val binding = ChannelItemBinding.bind(view.root)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ChannelsViewHolder(
        ChannelItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )


    override fun onBindViewHolder(holder: ChannelsViewHolder, position: Int) {
        bind(holder.binding, channelList[position], holder.itemView.context)
    }

    override fun getItemCount() = channelList.size

    private fun bind(binding: ChannelItemBinding, channel: Channel, context: Context) {
        setListeners(binding, channel, context)
        binding.channelNameTextView.text = channel.nameRu
        binding.programTextView.text = channel.title
        activeStar(channel.isActiveStar, binding, context)
        Picasso.get()
            .load(channel.image)
            .error(R.drawable.ic_launcher_foreground)
            .into(binding.imageChannel)
    }

    private fun setListeners(binding: ChannelItemBinding, channel: Channel, context: Context) {

        binding.cardView.setOnClickListener {
            onChannelItemClickListener?.invoke(channel)
        }

        binding.imageFavorite.setOnClickListener {
            val list = channelList.map {
                if (it.id == channel.id) {
                    it.isActiveStar = !it.isActiveStar
                }
                it
            }
            activeStar(channel.isActiveStar, binding, context)
            onStarClickListener?.invoke(list)
        }
    }

    private fun activeStar(isActive: Boolean, binding: ChannelItemBinding, context: Context) {
        if (isActive) {
            binding.imageFavorite.background = getDrawable(context, R.drawable.ic_star_active)
        } else {
            binding.imageFavorite.background = getDrawable(context, R.drawable.ic_star_inactive)
        }
    }

}

