package com.bc.week8demo2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ColorViewModelFactory(private val dao:ColorDao):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ColorViewModel::class.java)){
            return ColorViewModel(dao) as T
        }
        throw java.lang.IllegalArgumentException("unknown ViewModel class")
    }

}