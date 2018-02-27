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
import kotlinx.android.synthetic.main.fragment_transportation_webview_detail.*

/**
 * Created by saleemsangi on 2/17/18.
 */





class TransportationWebViewFragment : Fragment(){

    private var attractionsListURLS = arrayListOf(
            "https://www.ushmm.org/",
            "https://www.strathmore.org/",
            "https://www.nps.gov/wamo/index.htm",
            "https://www.nps.gov/vive/index.htm",
            "https://airandspace.si.edu/",
            "http://ldschurchtemples.org/washington/",
            "http://www.kennedy-center.org/",
            "https://www.si.edu/",
            "https://nationalzoo.si.edu/"
    )

    val otherTransport = hashMapOf("Bus Station" to "https://www.wmata.com/rider-guide/stations/white-flint.cfm", "Metro Station" to "https://www.wmata.com/rider-guide/stations/white-flint.cfm?y=12&y=12", "Train Station" to "https://www.amtrak.com/stations/rkv")

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater?.inflate(R.layout.fragment_transportation_webview_detail, null)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity.title = arguments.getString("selectedStation")

        if (webViewTransportationDetail != null){
            webViewTransportationDetail.settings.javaScriptEnabled = true

        }
        webViewTransportationDetail.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                view?.loadUrl(request?.url.toString())
                return true
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                view?.visibility = View.INVISIBLE
                if (progressBarTransportationWebViewDetail != null) {
                    progressBarTransportationWebViewDetail.visibility = View.VISIBLE

                }
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                view?.visibility  = View.VISIBLE
                if (progressBarTransportationWebViewDetail != null){
                    progressBarTransportationWebViewDetail.visibility = View.INVISIBLE

                }
            }
        }

        val selected = arguments.getString("selectedStation")

        if (selected != null){
            val loadingURL:String = otherTransport[selected]!!
            webViewTransportationDetail.loadUrl(loadingURL)

        }


    }
}