package com.example.saleemsangi.sana_dc

import android.graphics.Bitmap
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_attraction_detail.*
import kotlinx.android.synthetic.main.fragment_hotel.*

class AttractionDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attraction_detail)
        //setSupportActionBar(toolbar)

      //  val ss:String = intent.getStringExtra("valor")


        //Toast.makeText(context, ss + position, Toast.LENGTH_LONG).show()

        webViewAttractionDetailActivuty.settings.javaScriptEnabled = true
        webViewAttractionDetailActivuty.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                view?.loadUrl(request?.url.toString())
                return true
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                view?.visibility = View.INVISIBLE
                progressBarAttractionActivity.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                view?.visibility  = View.VISIBLE
                progressBarAttractionActivity.visibility = View.INVISIBLE
            }
        }

        webViewAttractionDetailActivuty.loadUrl("https://aws.passkey.com/e/49513241")
    }

}
