package com.example.saleemsangi.sana_dc

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_contact_sana.*





/**
 * Created by saleemsangi on 2/17/18.
 */


class ContactSanaFragment : Fragment(){

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        emailBtn.setOnClickListener{
            val mailer = Intent(Intent.ACTION_SEND)
            mailer.type = "text/plain"
            mailer.putExtra(Intent.EXTRA_EMAIL, arrayOf("info@sanaonline.org"))
            startActivity(Intent.createChooser(mailer, "Send email..."))
        }

        FBBtn.setOnClickListener {

            val facebookId = "fb://page/127510270772819"
            val urlPage = "https://www.facebook.com/127510270772819"
            try {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(facebookId)))
            } catch (e: Exception) {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(urlPage)))
            }

        }

        twitterBtn.setOnClickListener {

            var intent:Intent

            try {
                activity.packageManager.getPackageInfo("com.twitter.android", 0)
                intent = Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?user_id=SANA_Sindh2017"))
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            } catch (e: Exception){
                intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/SANA_Sindh2017"))
            }

            startActivity(intent)
        }

        instBTN.setOnClickListener {

            var intent:Intent

            try {
                activity.packageManager.getPackageInfo("com.instagram.android", 0)
                intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/_u/sindhiassociation"))
               // intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            } catch (e: Exception) {
                intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/sindhiassociation"))
            }

            startActivity(intent)
        }



    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        activity.title = "Contact SANA"

        return inflater?.inflate(R.layout.fragment_contact_sana, null)
    }
}
