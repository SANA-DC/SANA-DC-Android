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
import kotlinx.android.synthetic.main.activity_attraction_detail.*
import kotlinx.android.synthetic.main.fragment_attractions_detail.*

/**
 * Created by saleemsangi on 2/17/18.
 */


class AttractionsDetailFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater?.inflate(R.layout.fragment_attractions_detail, null)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        activity.setTitle("erer")

        webViewAttractionDetail.settings.javaScriptEnabled = true
        webViewAttractionDetail.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                view?.loadUrl(request?.url.toString())
                return true
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                view?.visibility = View.INVISIBLE
                progressBarAttractionDetail.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                view?.visibility  = View.VISIBLE
                progressBarAttractionDetail.visibility = View.INVISIBLE
            }
        }

        webViewAttractionDetail.loadUrl("https://aws.passkey.com/e/49513241")

    }
}