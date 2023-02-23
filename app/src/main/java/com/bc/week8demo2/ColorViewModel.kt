package com.bc.week8demo2

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ColorViewModel(private val colorDao:ColorDao):ViewModel() {

    fun addColor(color:Color){
        viewModelScope.launch{
            withContext(Dispatchers.IO){
                colorDao.insert(color)
                Log.v("Color", "add ${color.toString()}")
            }
        }
    }

    fun deleteColor(color:Color){
        viewModelScope.launch{
            withContext(Dispatchers.IO){
                colorDao.delete(color)
                Log.v("Color", "delete ${color.toString()}")
            }
        }
    }
}