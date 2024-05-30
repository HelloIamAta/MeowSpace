package com.example.meowspace.login

import androidx.fragment.app.viewModels
import android.os.Bundle
import android.text.SpannableString
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.meowspace.R
import com.example.meowspace.databinding.FragmentLoginBinding
import com.example.meowspace.utils.navigateTo

class LoginFragment : Fragment(R.layout.fragment_login) {

    private val viewModel: LoginViewModel by viewModels()
    private var binding : FragmentLoginBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fbinding = FragmentLoginBinding.bind(view)
        binding = fbinding

        binding!!.loginButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_mainPageFragment)
           // navigateTo(R.id.action_loginFragment_to_mainPageFragment,findNavController())
        }

        val sentence = binding!!.registerTextview.text.toString()
        val clickableWord = "Sign Up"

        val spannableString = SpannableString(sentence)
        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
            }
        }

        val startIndex = sentence.indexOf(clickableWord)
        val endIndex = startIndex + clickableWord.length
        spannableString.setSpan(clickableSpan, startIndex, endIndex, 0)

        binding!!.registerTextview.text = spannableString
        binding!!.registerTextview.movementMethod = LinkMovementMethod.getInstance()

    }
}