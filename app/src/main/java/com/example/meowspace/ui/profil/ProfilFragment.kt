package com.example.meowspace.ui.profil

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.meowspace.R
import com.example.meowspace.databinding.FragmentProfilBinding

class ProfilFragment : Fragment(R.layout.fragment_profil) {

    private val viewModel: ProfilViewModel by viewModels()
    private var binding : FragmentProfilBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fbinding = FragmentProfilBinding.bind(view)
        binding = fbinding

    }
}