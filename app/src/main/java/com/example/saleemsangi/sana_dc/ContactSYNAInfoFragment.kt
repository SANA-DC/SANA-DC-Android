package com.example.saleemsangi.sana_dc

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_syna_contact_info2.*

/**
 * Created by saleemsangi on 2/17/18.
 */


class ContactSYNAInfoFragment : Fragment(){

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        SYNA_Contact_INFOTextField.movementMethod = ScrollingMovementMethod()

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        activity.title = "About Me"

        return inflater?.inflate(R.layout.fragment_syna_contact_info2, null)
    }

}