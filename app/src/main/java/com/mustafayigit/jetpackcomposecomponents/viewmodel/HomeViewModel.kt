package com.mustafayigit.jetpackcomposecomponents.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel() {

    private val _count: MutableStateFlow<Int> = MutableStateFlow(INITIAL_COUNT)
    val count: StateFlow<Int> get() = _count.asStateFlow()

    fun incrementCount() {
        _count.value = _count.value + 1
    }

    fun resetCount() {
        _count.value = INITIAL_COUNT
    }

    companion object {
        const val INITIAL_COUNT = 0
    }

}