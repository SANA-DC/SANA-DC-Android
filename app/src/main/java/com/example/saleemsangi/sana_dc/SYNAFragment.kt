package com.example.saleemsangi.sana_dc

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_syna.*

/**
 * Created by saleemsangi on 2/17/18.
 */


class SYNAFragment : Fragment(){


    private var adapter : SYNAAdaptor?=null
    private var synaList = arrayListOf(
            "Schedule",
            "Voting"
    )


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         return inflater?.inflate(R.layout.fragment_syna, null)
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        activity.title = "SYNA"

        adapter = SYNAAdaptor(
               context,
                synaList
       )
        syna_ListView.adapter = adapter

        val test : ListView = view!!.findViewById(R.id.syna_ListView)
        test.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->

            if (position == 0) {
                val selected = synaList[position]

                val detailFragment = SYNAAgendaFragment()
                val transaction = fragmentManager.beginTransaction()
                transaction.replace(R.id.screenLayout, detailFragment).addToBackStack(null)
                transaction.commit()


            } else if (position == 1) {

                val detailFragment = SYNAVotingFragment()
                val transaction = fragmentManager.beginTransaction()
                transaction.replace(R.id.screenLayout, detailFragment).addToBackStack(null)
                transaction.commit()

            }

        }


    }

    inner class SYNAAdaptor: BaseAdapter {
        private var  listOfTransport = ArrayList<String>()
        private var context: Context?=null
        constructor(context: Context, listOfAttractions: ArrayList<String>):super(){
            this.listOfTransport=listOfAttractions
            this.context=context
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

            val layoutInflater = LayoutInflater.from(context)
            val row = layoutInflater.inflate(R.layout.attraction_row, p2, false) //TODO: Crashes here
            val titleTextView = row.findViewById<TextView>(R.id.titleTextView)
            titleTextView.text = synaList[p0]
            return row

        }

        override fun getItem(p0: Int): Any {
            return "testing"
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {

            return  synaList.size
        }


    }

}