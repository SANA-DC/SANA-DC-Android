package com.example.saleemsangi.sana_dc

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by saleemsangi on 2/17/18.
 */


class AgendaDetailFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_schedule_detail, null)
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {

        activity.title = "NOOOO"


    }

}