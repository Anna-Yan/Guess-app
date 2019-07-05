package com.example.guassapp_byannazaqaryan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.guassapp_byannazaqaryan.fragment.AccountFragment
import com.example.guassapp_byannazaqaryan.util.FOpenType
import com.example.guassapp_byannazaqaryan.util.FragmentTag
import com.example.guassapp_byannazaqaryan.util.openFragment
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.main_toolbar.*

class MainActivity : AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.userAccountButton ->{
//                AccountFragment.newInstance().openFragment(
//                    fragmentManager = this.supportFragmentManager,
//                    isAnimated = true, withBackStack = true, openType = FOpenType.ADD, tag = FragmentTag.FRAGMENT_ACCOUNT
//                )
            }
        }
    }
}
