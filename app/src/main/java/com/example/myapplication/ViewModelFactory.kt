package com.example.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory (val initialNum:Int): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            true -> {
             return MainViewModel(initialNum) as T
            }
            false -> {
             throw IllegalArgumentException("Wrong ViewModel Assign")
            }
        }
    }
}