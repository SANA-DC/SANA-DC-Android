package com.example.saleemsangi.sana_dc

import android.graphics.Bitmap
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.fragment_metro_map.*

/**
 * Created by saleemsangi on 2/17/18.
 */





class MetroMapFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater?.inflate(R.layout.fragment_metro_map, null)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        activity.title = "Metro Map"

        if (webViewMetroMap != null){
            webViewMetroMap.settings.javaScriptEnabled = true

        }
        webViewMetroMap.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                view?.loadUrl(request?.url.toString())
                return true
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                view?.visibility = View.INVISIBLE
                if (progressBarMetroMap != null) {
                    progressBarMetroMap.visibility = View.VISIBLE

                }
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                view?.visibility  = View.VISIBLE
                if (progressBarMetroMap != null){
                    progressBarMetroMap.visibility = View.INVISIBLE

                }
            }
        }
        val url = "http://docs.google.com/gview?embedded=true&url=" + "https://www.wmata.com/schedules/maps/upload/2017-System-Map.pdf"
        webViewMetroMap.loadUrl(url)

    }
}