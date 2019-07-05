package com.example.guassapp_byannazaqaryan

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.Animation
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.guassapp_byannazaqaryan.adapter.OnBoardingAdapter
import kotlinx.android.synthetic.main.activity_splash_screen.*
import kotlinx.android.synthetic.main.fragment_login.*
import android.view.animation.ScaleAnimation




class OnBoardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        initViewPager()
    }

    //Initialize ViewPager to scroll through tutorial slides
    private fun initViewPager() {
        tutorial_pager.adapter = OnBoardingAdapter(this)

        tutorial_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(i: Int, v: Float, i1: Int) {}
            override fun onPageSelected(progress: Int) {
                setTutorDotsProgressState(progress) }
            override fun onPageScrollStateChanged(i: Int) {} })
    }

    // Changing dots progress
    private fun setTutorDotsProgressState(progress: Int) {
        dot_1.setImageResource(R.drawable.shape_circle_white_fill)
        dot_2.setImageResource(R.drawable.shape_circle_white_fill)
        dot_3.setImageResource(R.drawable.shape_circle_white_fill)
        when (progress) {
            0 -> {
                scaleView(dot_1,1.4f,1.4f)
                scaleView(dot_2,1f,1f)
                scaleView(dot_3,1f,1f)
                dot_1.setImageResource(R.drawable.shape_circle_blue_fill)

            }
            1 -> {
                scaleView(dot_2,1.4f,1.4f)
                scaleView(dot_1,1f,1f)
                scaleView(dot_3,1f,1f)
                dot_2.setImageResource(R.drawable.shape_circle_blue_fill)
            }
            2 ->{
                scaleView(dot_3,1.4f,1.4f)
                scaleView(dot_1,1f,1f)
                scaleView(dot_2,1f,1f)
                dot_3.setImageResource(R.drawable.shape_circle_blue_fill)
                goToLoginPage()
            }
        }
    }

    // Go to the main screen of the application
   private fun goToLoginPage() {
        Handler().postDelayed({
           startActivity(Intent (this, MainActivity::class.java))
            finish()
        },2000)
    }

    private fun scaleView(v: View, startScale: Float, endScale: Float) {
        val anim = ScaleAnimation(
            startScale, endScale, // Start and end values for the X axis scaling
            startScale, endScale, // Start and end values for the Y axis scaling
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )
        anim.fillAfter = true // Needed to keep the result of the animation
        anim.duration = 1000
        v.startAnimation(anim)
    }

}

