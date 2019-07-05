package com.example.guassapp_byannazaqaryan.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.guassapp_byannazaqaryan.R
import kotlinx.android.synthetic.main.fragment_lose.*
import kotlinx.android.synthetic.main.main_toolbar.*

class LoseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lose, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        backButton.setOnClickListener{ findNavController().navigateUp() }
        userAccountButton.setOnClickListener{ findNavController().navigate(R.id.action_loseFragment_to_accountFragment)}
        powerButton.setOnClickListener{ activity?.finish()}
    }
}
