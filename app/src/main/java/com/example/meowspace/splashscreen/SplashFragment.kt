package com.example.meowspace.splashscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.load
import com.example.meowspace.R
import com.example.meowspace.databinding.FragmentSplashBinding
import java.util.Timer
import java.util.TimerTask

class SplashFragment : Fragment(R.layout.fragment_splash) {

    private var binding : FragmentSplashBinding? = null
    private val viewModel : SplashViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fbinding = FragmentSplashBinding.bind(view)
        binding = fbinding

        val imageGif = binding!!.gifImageView
        val imageLoader = ImageLoader.Builder(requireContext())
            .components {
                add(GifDecoder.Factory())
            }.build()
        imageGif.load(R.drawable.catgif, imageLoader)

        Timer().schedule(object : TimerTask() {
            override fun run() {
            viewModel.startTimer(R.id.action_splashFragment_to_loginFragment, findNavController())
            }
        }, 5000)

    }


}