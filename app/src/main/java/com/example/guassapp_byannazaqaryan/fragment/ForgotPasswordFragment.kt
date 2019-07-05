package com.example.guassapp_byannazaqaryan.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.guassapp_byannazaqaryan.R
import kotlinx.android.synthetic.main.fragment_forgot_password.*

class ForgotPasswordFragment : Fragment() {
    var passwordIsChanged: Boolean = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_forgot_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        submitBttn.setOnClickListener{
            passwordIsChanged = true
            val action = ForgotPasswordFragmentDirections.actionForgotPasswordFragment2ToLoginFragment().setPasswordChanged(passwordIsChanged)
            findNavController().navigate(action)

        }
    }
}
