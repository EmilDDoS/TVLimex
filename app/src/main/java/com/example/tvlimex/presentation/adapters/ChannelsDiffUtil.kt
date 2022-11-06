package com.example.tvlimex.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.tvlimex.domain.model.Channel

class ChannelsDiffUtil(
    private val oldList: List<Channel>,
    private val newList: List<Channel>
) : DiffUtil.Callback() {


    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem == newItem
    }
}