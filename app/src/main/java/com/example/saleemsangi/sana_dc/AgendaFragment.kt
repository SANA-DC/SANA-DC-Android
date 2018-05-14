package com.example.saleemsangi.sana_dc

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.fragment_agenda.*

/**
 * Created by saleemsangi on 2/17/18.
 */


class AgendaFragment : Fragment(){


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

    var day1List : MutableList<Session>? = null
    var day2List : MutableList<Session>? = null
    var day3List : MutableList<Session>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        day1List = mutableListOf()
        day2List = mutableListOf()
        day3List = mutableListOf()


    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        // Inflate the layout for this fragment

        activity.title = "Agenda"



        return inflater!!.inflate(R.layout.fragment_agenda, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view?.findViewById<RecyclerView>(R.id.recyler_view_agenda)
        recyclerView?.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        recyclerView?.layoutManager = LinearLayoutManager(context)
        recyclerView?.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        

        val ref = FirebaseDatabase.getInstance().reference
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) {
                Log.d("firebase", "cancelled")
            }

            override fun onDataChange(p0: DataSnapshot?) {

                if (p0!!.exists()){
                  //  Log.d("firebase", "date = ${p0.child("Day1")}")

                   // val day1:List<Session> = p0.child("Day1")
//                    for (days1 in p0.children){
//                        Log.d("firebase", "date = $h")
//
//                        for (session in days1){
//
//                        }
//
//                    }

                    var scheduleList : MutableList<AgendaRow> = mutableListOf()


                    var day1 = p0.child("Day1")
                    var day2 = p0.child("Day2")
                    var day3 = p0.child("Day3")

                    val headerOne = AgendaRow(RowType.HEADER, null, "FRIDAY, JULY 6", null)
                    scheduleList.add(headerOne)

                    for (session in day1.children){
                        val sessionClass = session.getValue(Session::class.java)
                        //day1List?.add(session!!)

                        val agendaRow = AgendaRow(RowType.SESSION_INFO, sessionClass, null, "FRIDAY, JULY 6")
                        scheduleList.add(agendaRow)
                    }
                    val headerTwo = AgendaRow(RowType.HEADER, null, "SATURDAY, JULY 7", null)
                    scheduleList.add(headerTwo)

                    for (session in day2.children){
                        val sessionClass = session.getValue(Session::class.java)

                        val agendaRow = AgendaRow(RowType.SESSION_INFO, sessionClass, null, "SATURDAY, JULY 7")
                        scheduleList.add(agendaRow)

                        //day2List?.add(session!!)

                    }

                    val headerThree = AgendaRow(RowType.HEADER, null, "SUNDAY, JULY 8", null)
                    scheduleList.add(headerThree)

                    for (session in day3.children){
                        val sessionClass = session.getValue(Session::class.java)
                        val agendaRow = AgendaRow(RowType.SESSION_INFO, sessionClass, null, "SUNDAY, JULY 8")
                        scheduleList.add(agendaRow)
                    }



                    progressBarAgenda?.visibility = View.INVISIBLE
                   // Log.d("seize of array", "= ${scheduleList!!.size}")

                    //recyclerView?.adapter = SessionAdaptorRecyclerView(scheduleList)
                    recyclerView?.adapter = SessionAdaptorRecyclerView(scheduleList){ session:Session, day:String ->

                       // val args = Bundle()

//                        args.putInt(
//                                "session",
//                                session
//                        )

                        //args.putParcelable("session", session)


//Session(val startTime:String, val endTime:String, val session:String, val room:String, val featuring:String, val lead:String, val category:String)

//                        args.putString("title", session.session)
//                        args.putString("startTime", session.startTime)
//                        args.putString("endTime", session.endTime)
//                        args.putString("room", session.room)
//                        args.putString("category", session.category)
//                        //args.putString("speaker", session.featuring)
//
//                        detailFragment.arguments = args

                        val singleton = Singleton.instance
                        singleton.session = session
                        singleton.day = day

                        val detailFragment = AgendaDetailFragment()
                        val transaction = fragmentManager.beginTransaction()
                        transaction.replace(R.id.screenLayout, detailFragment).addToBackStack(null)
                        transaction.commit()


                    }
                    view?.setBackgroundColor(Color.WHITE)


                } else {
                    Log.d("firebase", "no data")
                }

            }

        })

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


//5-05 23:09:27.563 12580-12672/com.saleemsangi.sana_dc I/DynamiteModule: Considering local module com.google.android.gms.firebase_database:4 and remote module com.google.android.gms.firebase_database:6
//05-05 23:09:27.563 12580-12672/com.saleemsangi.sana_dc I/DynamiteModule: Selected remote version of com.google.android.gms.firebase_database, version >= 6
//05-05 23:09:27.577 12580-12672/com.saleemsangi.sana_dc W/zygote: Unsupported class loader
//05-05 23:09:27.580 12580-12672/com.saleemsangi.sana_dc W/zygote: Skipping duplicate class check due to unsupported classloader
//05-05 23:09:27.605 12580-12673/com.saleemsangi.sana_dc D/NetworkSecurityConfig: No Network Security Config specified, using platform default
//05-05 23:09:27.650 12580-12585/com.saleemsangi.sana_dc I/zygote: Do partial code cache collection, code=122KB, data=73KB
//05-05 23:09:27.650 12580-12585/com.saleemsangi.sana_dc I/zygote: After code cache collection, code=122KB, data=73KB
//05-05 23:09:27.650 12580-12585/com.saleemsangi.sana_dc I/zygote: Increasing code cache capacity to 512KB