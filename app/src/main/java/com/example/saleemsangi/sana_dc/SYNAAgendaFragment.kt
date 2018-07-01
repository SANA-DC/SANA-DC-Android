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

        val session1Day1 = Session("6:00 pm", "9:00 pm", "Youth Registration ", "N/A", "", "", "SYNA")
        val agendaRow1Day1 = AgendaRow(RowType.SESSION_INFO, session1Day1, null, "FRIDAY, JULY 6")
        scheduleList.add(agendaRow1Day1)

        val session2Day1 = Session("8:00 pm", "10:00 pm", "Icebreakers", "White Oak A & B", "", "", "SYNA")
        val agendaRow2Day1 = AgendaRow(RowType.SESSION_INFO, session2Day1, null, "FRIDAY, JULY 6")
        scheduleList.add(agendaRow2Day1)

//////////////////
        val headerTwo = AgendaRow(RowType.HEADER, null, "SATURDAY, JULY 7", null)
        scheduleList.add(headerTwo)

        val session0Day2 = Session("8:45 am", "", "Meet in the lobby for check-in!", "N/A", "", "", "SYNA")
        val agendaRow0Day2 = AgendaRow(RowType.SESSION_INFO, session0Day2, null, "SATURDAY, JULY 7")
        scheduleList.add(agendaRow0Day2)

        val session1Day2 = Session("9:00 am", "4:00 pm", "DC Tour", "N/A", "", "", "SYNA")
        val agendaRow1Day2 = AgendaRow(RowType.SESSION_INFO, session1Day2, null, "SATURDAY, JULY 7")
        scheduleList.add(agendaRow1Day2)

        val session3Day2 = Session("9:00 pm", "10:00 pm", "Youth Hour", "ABCD", "", "", "SYNA")
        val agendaRow3Day2 = AgendaRow(RowType.SESSION_INFO, session3Day2, null, "SATURDAY, JULY 7")
        scheduleList.add(agendaRow3Day2)


////////////////////
        val headerThree = AgendaRow(RowType.HEADER, null, "SUNDAY, JULY 8", null)
        scheduleList.add(headerThree)

        val session1Day3 = Session("10 am", "11 am", "Interactive Panel with Saif Samejho", "White Oak", "", "", "SYNA")
        val agendaRow1Day3 = AgendaRow(RowType.SESSION_INFO, session1Day3, null, "SUNDAY, JULY 8")
        scheduleList.add(agendaRow1Day3)


        val session2Day3 = Session("11 am", "1 pm", "Career Panel", "White Oak", "", "", "SYNA")
        val agendaRow2Day3 = AgendaRow(RowType.SESSION_INFO, session2Day3, null, "SUNDAY, JULY 8")
        scheduleList.add(agendaRow2Day3)

        val session3Day3 = Session("10 pm", "Midnight", "Masquerade Ball - Dessert Banquet!", "White Oak", "", "", "SYNA")
        val agendaRow3Day3 = AgendaRow(RowType.SESSION_INFO, session3Day3, null, "SUNDAY, JULY 8")
        scheduleList.add(agendaRow3Day3)

        recyclerView?.adapter = SessionAdaptorRecyclerView(scheduleList) { session: Session, day: String ->


//            val singleton = Singleton.instance
//            singleton.session = session
//            singleton.day = day
//
//            val detailFragment = AgendaDetailFragment()
//            val transaction = fragmentManager.beginTransaction()
//            transaction.replace(R.id.screenLayout, detailFragment).addToBackStack(null)
//            transaction.commit()

            val singleton = Singleton.instance
            singleton.session = session
            singleton.day = day

            if(session.session == "Icebreakers"){
                singleton.SYNADescription = "-An introduction to the weekend\n-Icebreakers & Games\n-For ages 12 and younger: Face painting and balloon animals!"
            }
            else if(session.session == "DC Tour"){
                singleton.SYNADescription = "A tour of Capitol Hill and the National Mall - feel free to explore the monuments, take a trip to the museums, or stop at a food truck for a bite to eat!"
            }
            else if(session.session == "Youth Hour"){
                singleton.SYNADescription = "Various performers and speeches from the Youth. \n" +
                        "Welcome\n" +
                        "Dance - Numrah Shaikh\n" +
                        "Speech - Saad Ahmed Abbasi\n" +
                        "Skit\n" +
                        "Singing - Risha Shaikh\n" +
                        "Recognition of SYNA over the years - Sabrina Lakho\n" +
                        "Poetry Game - Will require audience participation!\n"
            }
            else if(session.session == "Interactive Panel with Saif Samejho"){
                singleton.SYNADescription = "An introduction to the weekend\nIcebreakers & Games\nFor ages 12 and younger: Face painting and balloon animals!"
            }
            else if(session.session == "Career Panel"){
                singleton.SYNADescription = "Panel for high school and College/University students to talk about their experiences in their respective career path \n" +
                        "-Business\n" +
                        "-Social Work/Mental Health therapist\n" +
                        "-Medicine/Bio\n" +
                        "-Art/Music\n" +
                        "-Criminal Justice/Law\n" +
                        "-Engineering\n"
            } else {
                singleton.SYNADescription = null
            }

            val detailFragment = AgendaDetailFragment()
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.screenLayout, detailFragment).addToBackStack(null)
            transaction.commit()

            view?.setBackgroundColor(Color.WHITE)

        }
    }

}