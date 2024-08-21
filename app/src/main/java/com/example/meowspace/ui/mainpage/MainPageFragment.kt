package com.example.meowspace.ui.mainpage

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.meowspace.ui.home.HomeFragment
import com.example.meowspace.R
import com.example.meowspace.databinding.FragmentMainPageBinding
import com.example.meowspace.ui.notification.NotificationFragment

class MainPageFragment : Fragment(R.layout.fragment_main_page) {

    private val viewModel: MainPageViewModel by viewModels()
    private var binding : FragmentMainPageBinding? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fbinding = FragmentMainPageBinding.bind(view)
        binding = fbinding
        openFragment(HomeFragment())

        binding!!.bottomNavigationView.setOnItemSelectedListener {it ->
            when (it.itemId){

                R.id.home -> {
                    openFragment(HomeFragment())
                    true}

                R.id.notification -> {
                    openFragment(NotificationFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.navbar_screen, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}