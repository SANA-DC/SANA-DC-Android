package com.example.saleemsangi.sana_dc

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by saleemsangi on 2/17/18.
 */


class SYNAAgendaFragment : Fragment(){


    //private var adapter : AttractionsAdaptor?=null
    //private var attractionsList = arrayListOf(
           // Session("16:00", "18:00", "ietnam Veterans Memorial", "Room: Larkana"
            //)

//            "Memebership and registration",
//            "Strathmore",
//            "Washington Monument",
//            "Vietnam Veterans Memorial",
//            "National Air and Space Museum",
//            "Washington D.C. Temple",
//            "Kennedy Center",
//            "Smithsonian",
//            "Smithsonian's National Zoo and Conservation Biology Institute"
  //  )


    //var ref: DatabaseReference? = null

    var scheduleList : MutableList<AgendaRow> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        // Inflate the layout for this fragment

        activity.title = "Agenda"



        return inflater!!.inflate(R.layout.fragment_syna_agenda, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view?.findViewById<RecyclerView>(R.id.recyler_view_agenda_syna)
        recyclerView?.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        recyclerView?.layoutManager = LinearLayoutManager(context)
        recyclerView?.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))


        val headerOne = AgendaRow(RowType.HEADER, null, "FRIDAY, JULY 6", null)
        scheduleList.add(headerOne)

        val session1Day1 = Session("08:00", "09:30", "Registration", "Larkana", "", "", "")
        val agendaRow1Day1 = AgendaRow(RowType.SESSION_INFO, session1Day1, null, "FRIDAY, JULY 6")
        scheduleList.add(agendaRow1Day1)

        val session2Day1 = Session("09:00", "09:30", "Icebreakers/Games", "Larkana", "", "", "")
        val agendaRow2Day1 = AgendaRow(RowType.SESSION_INFO, session2Day1, null, "FRIDAY, JULY 6")
        scheduleList.add(agendaRow2Day1)


        val headerTwo = AgendaRow(RowType.HEADER, null, "SATURDAY, JULY 7", null)
        scheduleList.add(headerTwo)


        val session1Day2 = Session("09:00", "04:00", "White House Tour, Tour of National Mall", "", "", "", "")
        val agendaRow1Day2 = AgendaRow(RowType.SESSION_INFO, session1Day2, null, "SATURDAY, JULY 7")
        scheduleList.add(agendaRow1Day2)

        val session2Day2 = Session("08:00", "10:00", "Dinner", "Larkana", "", "", "")
        val agendaRow2Day2 = AgendaRow(RowType.SESSION_INFO, session2Day2, null, "SATURDAY, JULY 7")
        scheduleList.add(agendaRow2Day2)

        val session3Day2 = Session("08:00", "10:00", "Dinner", "Youth Program", "", "", "")
        val agendaRow3Day2 = AgendaRow(RowType.SESSION_INFO, session3Day2, null, "SATURDAY, JULY 7")
        scheduleList.add(agendaRow3Day2)

        val headerThree = AgendaRow(RowType.HEADER, null, "SUNDAY, JULY 8", null)
        scheduleList.add(headerThree)

        val session1Day3 = Session("09:00", "04:00", "Youth Program", "", "", "", "")
        val agendaRow1Day3 = AgendaRow(RowType.SESSION_INFO, session1Day3, null, "SUNDAY, JULY 8")
        scheduleList.add(agendaRow1Day3)


        recyclerView?.adapter = SessionAdaptorRecyclerView(scheduleList) { session: Session, day: String ->


//            val singleton = Singleton.instance
//            singleton.session = session
//            singleton.day = day
//
//            val detailFragment = AgendaDetailFragment()
//            val transaction = fragmentManager.beginTransaction()
//            transaction.replace(R.id.screenLayout, detailFragment).addToBackStack(null)
//            transaction.commit()

            view?.setBackgroundColor(Color.WHITE)

        }
    }

}