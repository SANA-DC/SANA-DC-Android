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

    val dataToShow = arrayOf("sa", "sas", "sfd", "sasa")

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
            val textTest = itemView.findViewById<TextView>(R.id.address)
            textTest.text = "test"
        }
    }

}