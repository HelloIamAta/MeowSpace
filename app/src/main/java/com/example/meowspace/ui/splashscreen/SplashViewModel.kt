package com.example.meowspace.ui.splashscreen

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.meowspace.R

class SplashViewModel : ViewModel() {

    fun startTimer(action: Int, findNavController: NavController) {

        Handler(Looper.getMainLooper()).postDelayed({
            findNavController.navigate(action)
        }, 5000)

    }

}