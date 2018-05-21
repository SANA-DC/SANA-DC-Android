package com.example.saleemsangi.sana_dc

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import kotlinx.android.synthetic.main.fragment_welcome.*





/**
 * Created by saleemsangi on 2/17/18.
 */


class WelcomeFragment : Fragment(){

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textViewMessage.movementMethod = ScrollingMovementMethod()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        activity.title = "Welcome"

        return inflater?.inflate(R.layout.fragment_welcome, null)
    }

    override fun onResume() {
        super.onResume()


        val sharedPerfrence = context.getSharedPreferences("arrow",0 )

        val showArrow = sharedPerfrence.getBoolean("arrowInimation", false)

        if (!showArrow){
            val blinkanimation = AlphaAnimation(1f, 0f) // Change alpha from fully visible to invisible
            blinkanimation.duration = 500 // duration
            blinkanimation.interpolator = LinearInterpolator() // do not alter animation rate
            blinkanimation.repeatCount = Animation.INFINITE // Repeat animation infinitely
            blinkanimation.repeatMode = Animation.REVERSE
            arrowImage.animation = blinkanimation

            val editor  = sharedPerfrence.edit()
            editor.putBoolean("arrowInimation", true)
            editor.apply()
        } else {
            arrowImage.visibility = View.INVISIBLE
        }






    }

}