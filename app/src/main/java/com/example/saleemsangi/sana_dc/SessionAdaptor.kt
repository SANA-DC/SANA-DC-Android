package com.example.saleemsangi.sana_dc

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by saleemsangi on 5/5/18.
 */


//class SessionAdaptor
//Change from session to agenda row
class SessionAdaptorRecyclerView(val agenda:List<Session>) : RecyclerView.Adapter<SessionAdaptorRecyclerView.ViewHolder>() {


    override fun getItemCount(): Int {
        return agenda.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //val show = dataToShow.get(position)
        //holder.bind(agenda.)

        val session:Session = agenda.get(position)//.session
        session.let {
            holder.bind(session!!)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        return ViewHolder(layoutInflater.inflate(R.layout.agenda_row, parent, false))
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(session: Session) {
            itemView.findViewById<TextView>(R.id.textViewAgendaTitle).text = session.session
            itemView.findViewById<TextView>(R.id.textViewStartTime).text = session.startTime
            itemView.findViewById<TextView>(R.id.textViewEndTime).text = session.endTime
            val room = session.room
            itemView.findViewById<TextView>(R.id.textViewLocation).text = "Room : $room"

        }
    }

}