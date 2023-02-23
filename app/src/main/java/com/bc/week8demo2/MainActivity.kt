package com.bc.week8demo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val colorDao = ColorDatabase.getInstance(application).colorDao()

        val viewModelFactory = ColorViewModelFactory(colorDao)

        val viewModel = ViewModelProvider(this, viewModelFactory)[ColorViewModel::class.java]
        val red = Color(hex = "#ff0000", name = "red")
        val green = Color(hex = "#00ff00", name = "green")
        val blue = Color(hex = "#0000ff", name = "blue")

        viewModel.addColor(red)
        viewModel.addColor(red)
        viewModel.addColor(green)
        viewModel.addColor(green)
        viewModel.addColor(blue)
        viewModel.addColor(blue)

        colorDao.getColorByName("red").observe(this, Observer {
            if (it != null)
                viewModel.deleteColor(it)
        })

//        lifecycleScope.launch {
//            withContext(Dispatchers.IO) {
//                val newColor = Color(hex = "#6200EE", name = "purple")
//                colorDao.insert(newColor)
//            }
//        }
    }
}