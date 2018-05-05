package com.example.saleemsangi.sana_dc

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


class AgendaFragment : Fragment(){


    //private var adapter : AttractionsAdaptor?=null
    private var attractionsList = arrayListOf(
            Session("16:00", "18:00", "ietnam Veterans Memorial", "Room: Larkana"
            )

//            "Memebership and registration",
//            "Strathmore",
//            "Washington Monument",
//            "Vietnam Veterans Memorial",
//            "National Air and Space Museum",
//            "Washington D.C. Temple",
//            "Kennedy Center",
//            "Smithsonian",
//            "Smithsonian's National Zoo and Conservation Biology Institute"
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        activity.title = "Agenda"
        return inflater!!.inflate(R.layout.fragment_agenda, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        val recyclerView = view?.findViewById<RecyclerView>(R.id.recyler_view_agenda)
        recyclerView?.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        recyclerView?.layoutManager = LinearLayoutManager(context)
        recyclerView?.adapter = SessionAdaptorRecyclerView(attractionsList)
        super.onViewCreated(view, savedInstanceState)
    }


//    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//         return inflater?.inflate(R.layout.fragment_agenda, null)
//    }
//
//
//    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//
//        activity.title = "Agenda"
//
//        adapter = AttractionsAdaptor(
//               context,
//               attractionsList
//       )
//        agendaListView.adapter = adapter
//
//        val test : ListView = view!!.findViewById(R.id.agendaListView)
//        test.onItemClickListener = OnItemClickListener { _, _, position, _ ->
//           // Toast.makeText(context, "hello " + position, Toast.LENGTH_LONG).show()
//            print(position)
//
//
//            val detailFragment = AgendaDetailFragment()
//            val args = Bundle()
//
//            args.putInt(
//                    "selectedRow",
//                    position
//            )
//            args.putString("title", attractionsList[position])
//
//            detailFragment.arguments = args
//
//
//
//            val transaction = fragmentManager.beginTransaction()
//            transaction.replace(R.id.screenLayout, detailFragment).addToBackStack(null)
//            transaction.commit()
//
////           val intent = Intent(context, AttractionDetailActivity::class.java)
////            intent.putExtra("sa", "ss")
////            startActivity(intent)
//
//
//        }
//
//
//    }
//
//    inner class AttractionsAdaptor: BaseAdapter {
//        private var  listOfAttractions = ArrayList<String>()
//        private var context: Context?=null
//        constructor(context: Context, listOfAttractions: ArrayList<String>):super(){
//            this.listOfAttractions=listOfAttractions
//            this.context=context
//        }
//
//        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
//
//            val layoutInflator = LayoutInflater.from(context)
//            val row = layoutInflator.inflate(R.layout.agenda_row, p2, false) //TODO: Crashes here
//            val titleTextView = row.findViewById<TextView>(R.id.textViewAgendaTitle)
//            titleTextView.text = attractionsList[p0]
//
//            row.findViewById<TextView>(R.id.textViewStartTime).text =  "9:30 pm"
//            row.findViewById<TextView>(R.id.textViewLocation).text = "Room 34"
//            row.findViewById<TextView>(R.id.textViewTotalTime).text = "40 min"
//            return row
//
//        }
//
//        override fun getItem(p0: Int): Any {
//            return "testing"
//        }
//
//        override fun getItemId(p0: Int): Long {
//            return p0.toLong()
//        }
//
//        override fun getCount(): Int {
//
//            return  attractionsList.size
//        }
//
//
//    }

}