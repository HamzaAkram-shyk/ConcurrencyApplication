package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(private val initialNum: Int) : ViewModel() {

    private var score = MutableLiveData<Int>()
    var text = MutableLiveData<String>()

    val textObserve: LiveData<String> get() = text
    val scoreObserve: LiveData<Int> get() = score

    init {
        score.value = initialNum
        text.value = "hamza"
    }

    fun updateScore(num: Int) {
        score.value = score.value?.plus(num)

    }


}