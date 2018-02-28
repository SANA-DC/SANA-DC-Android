package com.example.saleemsangi.sana_dc

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by saleemsangi on 2/17/18.
 */


class AirportsFragment : Fragment(){

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        val selectedRow = arguments.getInt("selectedAirportIndex")

        if (selectedRow == 0){
            //"Washington Dulles International Airport - IAD"

        }

        else if (selectedRow == 1){
            // "Ronald Reagan Washington National Airport - DCA"

        }

        else if (selectedRow == 2){
           //"Baltimore/Washington International Thurgood Marshall Airport - BWI"

        }

        activity.title = "Airport"

        return inflater?.inflate(R.layout.fragment_airport, null)
    }

}