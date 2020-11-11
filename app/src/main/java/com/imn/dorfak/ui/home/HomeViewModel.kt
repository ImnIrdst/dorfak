package com.imn.dorfak.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<List<String>>().apply {
        val list = mutableListOf<String>()
        repeat(10) {
            list.add("IMN")
        }
        value = list
    }
    val text: LiveData<List<String>> = _text
}