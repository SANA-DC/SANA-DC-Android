package com.example.saleemsangi.sana_dc

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

}