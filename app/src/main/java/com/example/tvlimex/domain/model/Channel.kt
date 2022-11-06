package com.example.tvlimex.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Channel (
        val id: Int,
        val nameRu: String,
        val image: String,
        val title: String,
        val url: String,
        var isActiveStar: Boolean = false
) : Parcelable