package com.example.meowspace.ui.home

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meowspace.R
import com.example.meowspace.adapter.StoryAdapter
import com.example.meowspace.databinding.FragmentHomeBinding
import com.example.meowspace.response.StoryResponse

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModels()
    private var binding : FragmentHomeBinding? = null

    private lateinit var storyList : ArrayList<StoryResponse>
    private lateinit var storyAdapter : StoryAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        storyList = arrayListOf(
            StoryResponse(getString(R.string.cats),"Rikka"),
            StoryResponse(getString(R.string.cats1),"Yuuta"),
            StoryResponse(getString(R.string.cats2),"MochiMozzRoss"),
            StoryResponse(getString(R.string.cats3),"MerveAltinuer"),
            StoryResponse(getString(R.string.cats4),"Kucuk Siyah Kedi"),
            StoryResponse(getString(R.string.cats5),"Miyavcato"),
            StoryResponse(getString(R.string.cats6),"PisiPisi"),
            StoryResponse(getString(R.string.cats7),"Gayseks"),
        )



        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fbinding = FragmentHomeBinding.bind(view)
        binding = fbinding
        initObservers()

    }

    private fun initObservers() {

        val navController = findNavController()

        binding?.apply {

            storyRecyView.apply {
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                storyAdapter = StoryAdapter(requireContext(),storyList,navController)
                adapter = storyAdapter

            }

        }

    }

}