package com.example.guassapp_byannazaqaryan.util


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.guassapp_byannazaqaryan.R


fun Fragment.openFragment(
    container: Int = R.id.fragmentContainer, fragmentManager: FragmentManager?,
    withBackStack: Boolean = false, isAnimated: Boolean = true,
    openType: FOpenType = FOpenType.REPLACE, tag: FragmentTag?
) {
    val transaction = fragmentManager?.beginTransaction()
    if (isAnimated) transaction?.setCustomAnimations(
        R.anim.slide_in_right, R.anim.slide_out_left,
        R.anim.slide_in_left, R.anim.slide_out_right
    )
    else transaction?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
    if (openType == FOpenType.ADD) transaction?.add(container, this, tag?.name)
    else transaction?.replace(container, this, tag?.name)
    if (withBackStack) transaction?.addToBackStack(tag?.name)
    transaction?.commit()
}