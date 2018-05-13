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
class SessionAdaptorRecyclerView(val agenda:MutableList<AgendaRow>, val clickListener: (session:Session, day:String) -> Unit) : RecyclerView.Adapter<SessionAdaptorRecyclerView.ViewHolder>() {


    override fun getItemCount(): Int {
        return agenda.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //val show = dataToShow.get(position)
        //holder.bind(agenda.)

        if (agenda[position].type == RowType.SESSION_INFO)
        {
            val session:Session = agenda[position].session!!
            session.let {
                holder.bind(session!!, agenda[position].day!!)
            }
        } else {
            val title = agenda[position].headerTitle
            holder.bindHeader(title!!)
        }


    }

    override fun getItemViewType(position: Int): Int {
        if (agenda[position].type == RowType.SESSION_INFO){
            return return 0
        } else {
            return 1

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        if (viewType == RowType.SESSION_INFO.ordinal)
        {
            return ViewHolder(layoutInflater.inflate(R.layout.agenda_row, parent, false))

        } else {
            return ViewHolder(layoutInflater.inflate(R.layout.agenda_header, parent, false))

        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(session: Session, day:String) {
            itemView.findViewById<TextView>(R.id.textViewAgendaTitle).text = session.session
            itemView.findViewById<TextView>(R.id.textViewStartTime).text = session.startTime
            itemView.findViewById<TextView>(R.id.textViewEndTime).text = session.endTime
            val room = session.room
            itemView.findViewById<TextView>(R.id.textViewLocation).text = "Room : $room"
            itemView.setOnClickListener{clickListener(session, day)}

        }

        fun bindHeader(title:String){
            itemView.findViewById<TextView>(R.id.header_title).text = title
        }
    }

}