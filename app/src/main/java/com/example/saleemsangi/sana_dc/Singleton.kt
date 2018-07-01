package com.example.saleemsangi.sana_dc

/**
 * Created by saleemsangi on 5/13/18.
 */

public class Singleton private constructor() {
    init { println("This ($this) is a singleton") }

    private object Holder { val INSTANCE = Singleton() }

    companion object {
        val instance: Singleton by lazy { Holder.INSTANCE }
    }
    var session:Session? = null
    var day:String? = null
    var SYNADescription:String? = null

}
