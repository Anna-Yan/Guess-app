package com.example.guassapp_byannazaqaryan.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.guassapp_byannazaqaryan.R
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment(),View.OnClickListener {

   override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginBttn.setOnClickListener(this)
        forgotPasswordBttn.setOnClickListener(this)
        //When getting back from ChangePassword Fragment
        if(LoginFragmentArgs.fromBundle(arguments!!).passwordChanged){
            loginMessageText.visibility = View.VISIBLE
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.loginBttn -> findNavController().navigate(R.id.action_loginFragment_to_gameFragment)
            R.id.forgotPasswordBttn -> findNavController().navigate(R.id.action_loginFragment_to_forgotPasswordFragment)
        }
    }
}
