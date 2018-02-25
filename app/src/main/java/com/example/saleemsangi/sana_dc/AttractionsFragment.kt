package com.example.saleemsangi.sana_dc

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.*
import kotlinx.android.synthetic.main.fragment_attractions.*
import android.widget.Toast



/**
 * Created by saleemsangi on 2/17/18.
 */


class AttractionsFragment : Fragment(){


    private var adapter : AttractionsAdaptor?=null
    private var attractionsList = arrayListOf(
            "United States Holocaust Memorial Museum",
            "Strathmore",
            "Washington Monument",
            "Vietnam Veterans Memorial",
            "National Air and Space Museum",
            "Washington D.C. Temple",
            "Kennedy Center",
            "Smithsonian",
            "Smithsonian's National Zoo and Conservation Biology Institute"
    )


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         return inflater?.inflate(R.layout. fragment_attractions, null)
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        adapter = AttractionsAdaptor(
               context,
               attractionsList
       )
        attractionsListView.adapter = adapter

        val test : ListView = view!!.findViewById(R.id.attractionsListView)
        test.onItemClickListener =  AdapterView.OnItemClickListener { _, _, position, _ ->
           // Toast.makeText(context, "hello " + position, Toast.LENGTH_LONG).show()
            print(position)


            val detailFragment = AttractionsDetailFragment()
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.screenLayout, detailFragment).addToBackStack(null)
            transaction.commit()

//           val intent = Intent(context, AttractionDetailActivity::class.java)
//            intent.putExtra("sa", "ss")
//            startActivity(intent)

            activity.setTitle("test")

        }


    }

    inner class AttractionsAdaptor: BaseAdapter {
        private var  listOfAttractions = ArrayList<String>()
        private var context:Context?=null
        constructor(context:Context, listOfAttractions: ArrayList<String>):super(){
            this.listOfAttractions=listOfAttractions
            this.context=context
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

            val layoutInflator = LayoutInflater.from(context)
            val row = layoutInflator.inflate(R.layout.attraction_row, p2, false) //TODO: Crashes here
            val titleTextView = row.findViewById<TextView>(R.id.titleTextView)
            titleTextView.text = attractionsList[p0]
            return row

        }

        override fun getItem(p0: Int): Any {
            return "testing"
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {

            return  attractionsList.size
        }


    }

}