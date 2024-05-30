package com.example.meowspace.utils

import androidx.navigation.NavController

fun navigateTo(action: Int, findNavController: NavController){
    findNavController.navigate(action)
}