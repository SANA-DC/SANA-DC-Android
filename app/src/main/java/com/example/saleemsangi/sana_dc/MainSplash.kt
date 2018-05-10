package com.example.saleemsangi.sana_dc

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity


class MainSplash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Picasso.get().load(R.drawable.).into(splash_image)




        val background = object : Thread(){
            override fun run() {
                super.run()
                try {
                    Thread.sleep(1000)
                    val intent = Intent(baseContext, MainActivity::class.java)
                    startActivity(intent)

                } catch (e: Exception){

                }
            }
        }
        background.start()
    }

}