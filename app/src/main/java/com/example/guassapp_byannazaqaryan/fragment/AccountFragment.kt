package com.example.guassapp_byannazaqaryan.fragment


import android.os.Bundle
import android.service.voice.VoiceInteractionService
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.example.guassapp_byannazaqaryan.R
import kotlinx.android.synthetic.main.fragment_account.*

class AccountFragment : Fragment() {

    private lateinit var binding: com.example.guassapp_byannazaqaryan.databinding.FragmentAccountBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_account, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        saveBttn.setOnClickListener{
            messageText.visibility = View.VISIBLE
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = AccountFragment()
    }

}
