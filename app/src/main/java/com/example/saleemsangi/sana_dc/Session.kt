package com.example.saleemsangi.sana_dc

/**
 * Created by saleemsangi on 5/5/18.
 */


enum class RowType {
    INFO,
    HEADER
}


data class AgendaRow(var type: RowType, var session: Session?, var headerTitle: String?)


data class Session(val startTime:String, val endTime:String, val session:String, val room:String, val featuring:String, val lead:String, val category:String){
    constructor() : this("","","","","","",""){

    }
}