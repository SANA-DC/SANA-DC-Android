package com.example.saleemsangi.sana_dc

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_transport.*
import android.widget.AdapterView.OnItemClickListener

/**
 * Created by saleemsangi on 2/17/18.
 */


class TransportFragment : Fragment(){


    private var adapter : TransportAdaptor?=null
    private var transportList = arrayListOf(
            "Washington Dulles International Airport - IAD",
            "Ronald Reagan Washington National Airport - DCA",
            "Baltimore/Washington International Thurgood Marshall Airport - BWI",
            "Parking",
            "Bus Station",
            "Subway Station",
            "Train Station",
            "Car Rentals"
    )


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         return inflater?.inflate(R.layout.fragment_transport, null)
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        activity.title = "Transport"

        adapter = TransportAdaptor(
               context,
                transportList
       )
        transportListView.adapter = adapter

        val test : ListView = view!!.findViewById(R.id.transportListView)
        test.onItemClickListener = OnItemClickListener { _, _, position, _ ->
           // Toast.makeText(context, "hello " + position, Toast.LENGTH_LONG).show()
            print(position)


            val detailFragment = AttractionsDetailFragment()
            val args = Bundle()
            args.putInt(
                    "selectedRow",
                    position
            )
            args.putString("title", transportList[position])

            detailFragment.arguments = args



            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.screenLayout, detailFragment).addToBackStack(null)
            transaction.commit()

//           val intent = Intent(context, AttractionDetailActivity::class.java)
//            intent.putExtra("sa", "ss")
//            startActivity(intent)


        }


    }

    inner class TransportAdaptor: BaseAdapter {
        private var  listOfTrasnport = ArrayList<String>()
        private var context: Context?=null
        constructor(context: Context, listOfAttractions: ArrayList<String>):super(){
            this.listOfTrasnport=listOfTrasnport
            this.context=context
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

            val layoutInflater = LayoutInflater.from(context)
            val row = layoutInflater.inflate(R.layout.attraction_row, p2, false) //TODO: Crashes here
            val titleTextView = row.findViewById<TextView>(R.id.titleTextView)
            titleTextView.text = transportList[p0]
            return row

        }

        override fun getItem(p0: Int): Any {
            return "testing"
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {

            return  transportList.size
        }


    }

}