package com.example.tvlimex.presentation.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tvlimex.domain.model.Channel
import com.example.tvlimex.domain.usecase.DbUseCase
import com.example.tvlimex.domain.usecase.GetChannelsUseCase
import com.example.tvlimex.domain.usecase.GetLocalChannelsUseCase
import kotlinx.coroutines.launch

class FavoriteChannelsViewModel(
    private val getLocalChannelsUseCase: GetLocalChannelsUseCase,
    private val dbUseCase: DbUseCase
) : ViewModel() {

    suspend fun getListDb() = dbUseCase.getListChannelsDb()

    fun deleteChannelDb(id: Int) {
        viewModelScope.launch {
            dbUseCase.deleteChannelItem(id)
        }
    }

}