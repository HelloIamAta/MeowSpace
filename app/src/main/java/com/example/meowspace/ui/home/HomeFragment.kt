package com.example.meowspace.ui.home

import PostAdapter
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meowspace.R
import com.example.meowspace.adapter.StoryAdapter
import com.example.meowspace.databinding.FragmentHomeBinding
import com.example.meowspace.response.PostResponse
import com.example.meowspace.response.StoryResponse
import com.example.meowspace.utils.session.SessionManager

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModels()
    private var binding : FragmentHomeBinding? = null

    private lateinit var storyList : ArrayList<StoryResponse>
    private lateinit var postList : ArrayList<PostResponse>
    private lateinit var storyAdapter : StoryAdapter
    private lateinit var postAdapter : PostAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        storyList = arrayListOf(
            StoryResponse(getString(R.string.cats),"Rikka"),
            StoryResponse(getString(R.string.cats1),"Yuuta"),
            StoryResponse(getString(R.string.cats2),"Mochi Mozz Ross"),
            StoryResponse(getString(R.string.cats3),"Merve Altinuer"),
            StoryResponse(getString(R.string.cats4),"Kucuk Siyah Kedi"),
            StoryResponse(getString(R.string.cats5),"Miyavcato"),
            StoryResponse(getString(R.string.cats6),"PisiPisi"),
            StoryResponse(getString(R.string.cats7),"Gayseks"),
        )

        postList = arrayListOf(
            PostResponse(getString(R.string.cats),"Rikka",getString(R.string.cats),"Cats are natural-born hunters."),
            PostResponse(getString(R.string.cats1),"Yuuta",getString(R.string.cats1),"A cat's purr can be calming."),
            PostResponse(getString(R.string.cats2),"Mochi Mozz Ross",getString(R.string.cats2),"Cats are natural-born hunters. Their instincts kick in even during playtime, turning your living room into a mini jungle."),
            PostResponse(getString(R.string.cats3),"Merve Altinuer",getString(R.string.cats3),"\"The smallest feline is a masterpiece.\" This quote by Leonardo da Vinci perfectly captures the grace and beauty that every cat possesses. Whether they’re leaping gracefully or curling up for a nap, cats have an elegance that’s simply unmatched."),
            PostResponse(getString(R.string.cats4),"Kucuk Siyah Kedi",getString(R.string.cats4),"Kittens love to chase laser pointers."),
            PostResponse(getString(R.string.cats5),"Miyavcato",getString(R.string.cats5),"Cats sleep up to 16 hours a day."),
            PostResponse(getString(R.string.cats6),"PisiPisi",getString(R.string.cats6),"Cats groom themselves to stay clean."),
            PostResponse(getString(R.string.cats7),"Gayseks",getString(R.string.cats7),"A cat's tail reveals its mood."),
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


            postRecyView.apply {
                val session = SessionManager(requireContext())
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                postAdapter = PostAdapter(requireContext(),postList,navController,session)
                adapter = postAdapter

            }

        }

    }

}