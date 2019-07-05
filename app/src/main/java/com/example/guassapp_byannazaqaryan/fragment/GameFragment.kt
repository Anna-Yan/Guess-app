package com.example.guassapp_byannazaqaryan.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.guassapp_byannazaqaryan.R
import com.example.guassapp_byannazaqaryan.util.PreferencesManager
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.main_toolbar.*
import kotlin.random.Random


class GameFragment : Fragment(), View.OnClickListener{
    private var randomNum1:Int = 0
    private var randomNum2:Int = 0
    private var level:Int = 0
    private lateinit var prefs: PreferencesManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prefs = PreferencesManager.getInstance(requireContext())
        setupListeners()
        generateRandomNumber()
    }

    private fun setupListeners(){
        button0.setOnClickListener(this)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        buttonX.setOnClickListener(this)
        button_clear.setOnClickListener(this)
        playButton.setOnClickListener(this)
        userAccountButton.setOnClickListener(this)
        powerButton.setOnClickListener(this)
    }

    private fun generateRandomNumber() {
        guessNumber1.setText("")
        guessNumber2.setText("")
        randomNum1  = Random.nextInt(10-1)+1 //1..9
        randomNum2  = Random.nextInt(10-1)+0 //0..9
        Log.i("check", "level=$level")
        level++
        prefs.putInt(PreferencesManager.GUESS_NUMBER_1,randomNum1)
        prefs.putInt(PreferencesManager.GUESS_NUMBER_2,randomNum2)
        prefs.putInt(PreferencesManager.LEVEL,level)
    }

    private fun clearData(){
        prefs.clearData()
        level = 0
        guessNumber1.setText("")
        guessNumber2.setText("")
    }

    private fun getPreferences(){
        level = prefs.getInt(PreferencesManager.LEVEL,0)
        randomNum1 = prefs.getInt(PreferencesManager.GUESS_NUMBER_1,0)
        randomNum2 = prefs.getInt(PreferencesManager.GUESS_NUMBER_2,0)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button0 -> {
               if (guessNumber1.text?.matches("".toRegex())!!) guessNumber1.setText("0") else guessNumber2.setText("0")
            }
            R.id.button1 -> {
                if (guessNumber1.text?.matches("".toRegex())!!) guessNumber1.setText("1") else guessNumber2.setText("1")
            }
            R.id.button2 -> {
                if (guessNumber1.text?.matches("".toRegex())!!) guessNumber1.setText("2") else guessNumber2.setText("2")
            }
            R.id.button3 -> {
                if (guessNumber1.text?.matches("".toRegex())!!) guessNumber1.setText("3") else guessNumber2.setText("3")
            }
            R.id.button4 -> {
                if (guessNumber1.text?.matches("".toRegex())!!) guessNumber1.setText("4") else guessNumber2.setText("4")
            }
            R.id.button5 -> {
                if (guessNumber1.text?.matches("".toRegex())!!) guessNumber1.setText("5") else guessNumber2.setText("5")
            }
            R.id.button6 -> {
                if (guessNumber1.text?.matches("".toRegex())!!) guessNumber1.setText("6") else guessNumber2.setText("6")
            }
            R.id.button7 -> {
                if (guessNumber1.text?.matches("".toRegex())!!) guessNumber1.setText("7") else guessNumber2.setText("7")
            }
            R.id.button8 -> {
                if (guessNumber1.text?.matches("".toRegex())!!) guessNumber1.setText("8") else guessNumber2.setText("8")
            }
            R.id.button9 -> {
                if (guessNumber1.text?.matches("".toRegex())!!) guessNumber1.setText("9") else guessNumber2.setText("9")
            }
            R.id.buttonX -> {
                guessNumber1.setText("")
                guessNumber2.setText("")
            }
            R.id.button_clear -> {
                if(!guessNumber2.text?.matches("".toRegex())!!) guessNumber2.setText("") else guessNumber1.setText("")
            }
            R.id.playButton -> {
                getPreferences()
                when(level) {
                1 -> {
                    if (guessNumber1.text.toString() == randomNum1.toString() && guessNumber2.text.toString() == randomNum2.toString()) {
                        findNavController().navigate(R.id.action_gameFragment_to_winFragment)
                        clearData()
                    } else {
                        chancesLeftText.text = resources.getText(R.string.chancesLeftIs2)
                        generateRandomNumber()
                    }
                }
                2 -> {
                    if (guessNumber1.text.toString() == randomNum1.toString() && guessNumber2.text.toString() == randomNum2.toString()) {
                        findNavController().navigate(R.id.action_gameFragment_to_winFragment)
                        clearData()
                    } else {
                        chancesLeftText.text = resources.getText(R.string.chancesLeftIs1)
                        generateRandomNumber()
                    }
                }
                3 -> {
                    if (guessNumber1.text.toString() == randomNum1.toString() && guessNumber2.text.toString() == randomNum2.toString()) {
                        findNavController().navigate(R.id.action_gameFragment_to_winFragment)
                    } else {
                        findNavController().navigate(R.id.action_gameFragment_to_loseFragment)
                    }
                    clearData()
                }
              }
            }
            R.id.userAccountButton -> findNavController().navigate(R.id.action_gameFragment_to_accountFragment)
            R.id.powerButton -> activity?.finish()
        }
    }
}
