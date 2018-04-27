package com.example.saleemsangi.sana_dc

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by saleemsangi on 4/26/18.
 */

class RestaurantsAdaptorRecyclerView : RecyclerView.Adapter<RestaurantsAdaptorRecyclerView.ViewHolder>() {

    val dataToShow = arrayOf("Toosso\n" +
            "\n" +
            "1596 Rockville Pike A, Rockville, MD 20852\n" +
            "\n" +
            "(301) 768-4645\n" +
            "\n" +
            "1.4 Miles",
            "The Halal Guys\n" +
                    "\n" +
                    "891 Rockville Pike, \nRockville, MD 20852\n" +
                    "\n" +
                    "(301) 545-2988\n" +
                    "\n" +
                    "2.6 Miles",
            "Amina Thai Restaurant\n" +
                    "\n" +
                    "5065 Nicholson Lane, Rockville, \nMD 20852\n" +
                    "\n" +
                    "(301) 770-9509\n" +
                    "\n" +
                    "0.7 Miles",
            "Grill Kabob\n" +
                    "\n" +
                    "7101 Democracy Boulevard \n#2367,\n" +
                    "Bethesda, MD 20817\n" +
                    "\n" +
                    "(301) 365-3741\n" +
                    "\n" +
                    "3.3 Miles",
            "Yekta Kabobi Restaurant\n" +
                    "\n" +
                    "1488 Rockville Pike\n" +
                    "Ste A\n" +
                    "Rockville, MD 20852\n" +
                    "\n" +
                    "(301) 984-0005\n" +
                    "\n" +
                    "1.6 Miles")




    override fun getItemCount(): Int {
        return dataToShow.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //val show = dataToShow.get(position)
        holder.bind(position)

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)

        return ViewHolder(layoutInflater.inflate(R.layout.row_halal_restaurants, parent, false))
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(position: Int) {
            val textTest = itemView.findViewById<TextView>(R.id.title)
            textTest.text = dataToShow[position]
        }
    }

}