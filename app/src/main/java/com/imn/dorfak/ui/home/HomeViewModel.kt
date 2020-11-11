package com.imn.dorfak.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _urls = MutableLiveData<List<String>>().apply {
        val list = mutableListOf<String>()
        repeat(3) {
            list.add("https://images.unsplash.com/photo-1605020419924-5c30f7baad47?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&dl=de-an-sun-qIOm5OLIXsc-unsplash.jpg")
            list.add("https://images.unsplash.com/photo-1604987293212-5aea39d94ccb?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&dl=vladislav-zaytsev-RtIsEA9x3w4-unsplash.jpg")
            list.add("https://images.unsplash.com/photo-1605073503373-24ea357e74c8?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&dl=aseem-chaudhary-7Y1-Nzn98CM-unsplash.jpg")
        }
        value = list
    }
    val urls: LiveData<List<String>> = _urls
}