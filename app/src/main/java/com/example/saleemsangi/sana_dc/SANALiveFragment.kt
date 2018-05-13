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
import kotlinx.android.synthetic.main.activity_sana_live.*

/**
 * Created by saleemsangi on 2/17/18.
 */





class SANALiveFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater?.inflate(R.layout.activity_sana_live, null)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        activity.title = "SANA Live"

        if (webViewSanaLive != null){
            webViewSanaLive.settings.javaScriptEnabled = true

        }
        webViewSanaLive.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                view?.loadUrl(request?.url.toString())
                return true
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                view?.visibility = View.INVISIBLE
                if (progressBarSanaLive != null) {
                    progressBarSanaLive.visibility = View.VISIBLE

                }
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                view?.visibility  = View.VISIBLE
                if (progressBarSanaLive != null){
                    progressBarSanaLive.visibility = View.INVISIBLE

                }
            }
        }

        webViewSanaLive.loadUrl("https://sanaonline.org/live")

    }
}