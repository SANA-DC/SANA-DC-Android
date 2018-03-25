package com.example.saleemsangi.sana_dc

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
//import com.google.android.gms.maps.model.LatLng
import kotlinx.android.synthetic.main.fragment_airport.*
//import com.google.android.gms.maps.model.MarkerOptions


//import com.google.android.gms.maps.CameraUpdateFactory
//import com.google.android.gms.maps.GoogleMap
//import com.google.android.gms.maps.OnMapReadyCallback
//import com.google.android.gms.maps.SupportMapFragment


/**
 * Created by saleemsangi on 2/17/18.
 */


class AirportsFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout. fragment_airport, null)
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {


        val selectedRow = arguments.getInt("selectedAirportIndex")

        if (selectedRow == 0){
            textView2.text = "Washington Dulles International Airport - IAD"
            textView3.text = "1 Saarinen Cir \nDulles, VA 20166 \nPhone: +1 703 572 2700 \n\nHotel direction: 25 miles NE"
            textView5.text = "Estimated taxi fare: 60 USD  (one way)"

            //"Washington Dulles International Airport - IAD"

        }

        else if (selectedRow == 1){
            // "Ronald Reagan Washington National Airport - DCA"
            textView2.text = "Ronald Reagan Washington National Airport - DCA"
            textView3.text = "Ronald Reagan Washington National Airport \nPhone: +1 703 417 8000 \n\nHotel direction: 23 miles NW"
            textView5.text = "Estimated taxi fare: 55 USD  (one way)"

        }

        else if (selectedRow == 2){
            textView2.text = "Baltimore/Washington International Thurgood Marshall Airport - BWI"
            textView3.text = "Baltimore–Washington \nInternational Airport \nPhone: +1 410 859 7111 \n\nHotel direction: 37.6 miles SW"
            textView5.text = "Estimated taxi fare: 70 USD  (one way)"
            //"Baltimore/Washington International Thurgood Marshall Airport - BWI"

        }

        activity.title = "Airport"


    }

}