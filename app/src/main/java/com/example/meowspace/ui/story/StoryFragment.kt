package com.example.meowspace.ui.story

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.meowspace.R
import com.example.meowspace.databinding.FragmentLoginBinding
import com.example.meowspace.databinding.FragmentStoryBinding

class StoryFragment : Fragment(R.layout.fragment_story) {


    private val viewModel: StoryViewModel by viewModels()
    private var binding : FragmentStoryBinding? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fbinding = FragmentStoryBinding.bind(view)
        binding = fbinding

        fbinding.closeButton.setOnClickListener {

            requireActivity().supportFragmentManager.popBackStack()

        }

        fbinding.sendStoryMessage.setOnClickListener {
            Toast.makeText(requireContext(), "MERVE SENI SEVIYORUM", Toast.LENGTH_SHORT).show()
        }

    }



}