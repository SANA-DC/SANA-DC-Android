package com.example.saleemsangi.sana_dc

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_schedule_detail.*

/**
 * Created by saleemsangi on 2/17/18.
 */


class AgendaDetailFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_schedule_detail, null)
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {

        activity.title = "Session Detail"


        /*

         args.putString("title", session.session)
                        args.putString("startTime", session.startTime)
                        args.putString("endTime", session.endTime)
                        args.putString("room", session.room)
                        args.putString("category", session.category)
         */


        //val args = Bundle()

        //this.arguments = args

        val session = Singleton.instance.session
        textViewTitle.text = session?.session
        textViewTime.text = "${session?.startTime} - ${session?.endTime}"
        //textViewDay.text = session?.session
        textViewLocationDetail.text = "Room: ${session?.room}"
        textViewDay.text = Singleton.instance.day
        val category = session?.category
        if (category == "Speaker Session"){
            textViewDescription.text = session?.featuring
        } else if (category == "SYNA" && Singleton.instance.SYNADescription != null){
            textViewDescription.text = Singleton.instance.SYNADescription
        }
        else {
            textViewDescription.visibility = View.INVISIBLE
        }

    }

}