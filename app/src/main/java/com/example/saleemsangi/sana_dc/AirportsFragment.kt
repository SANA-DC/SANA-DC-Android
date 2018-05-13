package com.example.saleemsangi.sana_dc

//import com.google.android.gms.maps.model.LatLng
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.GoogleMap
import kotlinx.android.synthetic.main.fragment_airport.*

//import com.google.android.gms.maps.model.MarkerOptions


//import com.google.android.gms.maps.CameraUpdateFactory
//import com.google.android.gms.maps.GoogleMap
//import com.google.android.gms.maps.OnMapReadyCallback
//import com.google.android.gms.maps.SupportMapFragment


/**
 * Created by saleemsangi on 2/17/18.
 */


class AirportsFragment : Fragment(){//}, OnMapReadyCallback {

    private var mMap: GoogleMap? = null



    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout. fragment_airport, null)
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {

      //  val mapFragment = fragmentManager.findFragmentById(R.id.mapView) as SupportMapFragment
       // mapFragment.getMapAsync(this)

        //Picasso.with(context).load(R.drawable.drawableName).into(imageView);
       // Picasso.get().load(R.drawable.iad_hotel).into(imageView)


        val selectedRow = arguments.getInt("selectedAirportIndex")

        if (selectedRow == 0){
            textView2.text = "Washington Dulles International Airport - IAD"
            textView3.text = "1 Saarinen Cir \nDulles, VA 20166 \nPhone: +1 703 572 2700 \n\nHotel direction: 25 miles NE"
            textView5.text = "Estimated taxi fare: 60 USD  (one way)"
            imageView.setImageResource(R.drawable.iad_hotel)


            //"Washington Dulles International Airport - IAD"

        }

        else if (selectedRow == 1){
            // "Ronald Reagan Washington National Airport - DCA"
            textView2.text = "Ronald Reagan Washington National Airport - DCA"
            textView3.text = "Ronald Reagan Washington National Airport \nPhone: +1 703 417 8000 \n\nHotel direction: 23 miles NW"
            textView5.text = "Estimated taxi fare: 55 USD  (one way)"
            imageView.setImageResource(R.drawable.dca_hotel)


        }

        else if (selectedRow == 2){
            textView2.text = "Baltimore/Washington International Thurgood Marshall Airport - BWI"
            textView3.text = "Baltimore–Washington \nInternational Airport \nPhone: +1 410 859 7111 \n\nHotel direction: 37.6 miles SW"
            textView5.text = "Estimated taxi fare: 70 USD  (one way)"
            imageView.setImageResource(R.drawable.bwi_hotel)

            //"Baltimore/Washington International Thurgood Marshall Airport - BWI"

        }

        activity.title = "Airport"

    }


//    override fun onMapReady(googleMap: GoogleMap) {
//        mMap = googleMap
//        val LatLongB = LatLngBounds.Builder()
//
//        // Add markers
//        val sydney = LatLng(-34.0, 151.0)
//        val opera = LatLng(-33.9320447,151.1597271)
//        mMap!!.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
//        mMap!!.addMarker(MarkerOptions().position(opera).title("Opera House"))
//
//        // Declare polyline object and set up color and width
//        val options = PolylineOptions()
//        options.color(Color.RED)
//        options.width(5f)
//
//        // build URL to call API
//        val url = getURL(sydney, opera)
//
//       // async {
//            // Connect to URL, download content and convert into string asynchronously
//            val result = URL(url).readText()
//         //   uiThread {
//                // When API call is done, create parser and convert into JsonObjec
//                val parser: com.beust.klaxon.Parser = Parser()
//                val stringBuilder: StringBuilder = StringBuilder(result)
//                val json: JsonObject = parser.parse(stringBuilder) as JsonObject
//                // get to the correct element in JsonObject
//                val routes = json.array<JsonObject>("routes")
//                val points = routes!!["legs"]["steps"][0] as JsonArray<JsonObject>
//                // For every element in the JsonArray, decode the polyline string and pass all points to a List
//                val polypts = points.flatMap { decodePoly(it.obj("polyline")?.string("points")!!)  }
//                // Add  points to polyline and bounds
//                options.add(sydney)
//                LatLongB.include(sydney)
//                for (point in polypts)  {
//                    options.add(point)
//                    LatLongB.include(point)
//                }
//                options.add(opera)
//                LatLongB.include(opera)
//                // build bounds
//                val bounds = LatLongB.build()
//                // add polyline to the map
//                mMap!!.addPolyline(options)
//                // show map with route centered
//                mMap!!.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 100))
//         //   }
//        //}
//    }
//
//    private fun getURL(from : LatLng, to : LatLng) : String {
//        val origin = "origin=" + from.latitude + "," + from.longitude
//        val dest = "destination=" + to.latitude + "," + to.longitude
//        val sensor = "sensor=false"
//        val params = "$origin&$dest&$sensor"
//        return "https://maps.googleapis.com/maps/api/directions/json?$params"
//    }
//
//    /**
//     * Method to decode polyline points
//     * Courtesy : https://jeffreysambells.com/2010/05/27/decoding-polylines-from-google-maps-direction-api-with-java
//     */
//    private fun decodePoly(encoded: String): List<LatLng> {
//        val poly = ArrayList<LatLng>()
//        var index = 0
//        val len = encoded.length
//        var lat = 0
//        var lng = 0
//
//        while (index < len) {
//            var b: Int
//            var shift = 0
//            var result = 0
//            do {
//                b = encoded[index++].toInt() - 63
//                result = result or (b and 0x1f shl shift)
//                shift += 5
//            } while (b >= 0x20)
//            val dlat = if (result and 1 != 0) (result shr 1).inv() else result shr 1
//            lat += dlat
//
//            shift = 0
//            result = 0
//            do {
//                b = encoded[index++].toInt() - 63
//                result = result or (b and 0x1f shl shift)
//                shift += 5
//            } while (b >= 0x20)
//            val dlng = if (result and 1 != 0) (result shr 1).inv() else result shr 1
//            lng += dlng
//
//            val p = LatLng(lat.toDouble() / 1E5,
//                    lng.toDouble() / 1E5)
//            poly.add(p)
//        }
//
//        return poly
//    }

    }