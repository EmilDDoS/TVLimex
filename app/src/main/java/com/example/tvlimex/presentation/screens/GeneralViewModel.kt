package com.example.tvlimex.presentation.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tvlimex.domain.model.Channel
import com.example.tvlimex.domain.usecase.GetChannelsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class GeneralViewModel(
    private val getChannelUseCase: GetChannelsUseCase
) : ViewModel() {
}