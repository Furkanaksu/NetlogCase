package com.mobillium.netlogcase.fragments

import android.content.Intent
import android.graphics.Camera
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.mobillium.netlogcase.CameraActivity
import com.mobillium.netlogcase.pdf.PdfActivity
import com.mobillium.netlogcase.map.MapActivity
import com.mobillium.netlogcase.map.MapsFragment
import com.mobillium.netlogcase.R
import com.mobillium.netlogcase.managers.Globals


class SecondFragment : Fragment() {

    var city : TextView? = null
    var prov : TextView? = null
    var address : TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_second, container, false)
       val mMapView = rootView.findViewById<FrameLayout>(R.id.mapView)
       val openPdf = rootView.findViewById<ImageView>(R.id.openPdf)
       val openCamera = rootView.findViewById<TextView>(R.id.openCamera)

        openPdf.setOnClickListener {
            val i = Intent(context, PdfActivity::class.java)
            startActivity(i)
        }

        city = rootView.findViewById(R.id.city)
        prov = rootView.findViewById(R.id.prov)
        address = rootView.findViewById(R.id.address)


        activity!!.supportFragmentManager
            .beginTransaction()
            .replace(R.id.mapView, MapsFragment())
            .commit()

        mMapView.setOnClickListener {
            val i = Intent(context, MapActivity::class.java)
            startActivity(i)
        }

        openCamera.setOnClickListener {

            val i = Intent(context, CameraActivity::class.java)
            startActivity(i)

        }

        return rootView
    }

    override fun onResume() {

        if (!Globals.shared.City.isNullOrEmpty())
        {
            city?.text = Globals.shared.City
            prov?.text = Globals.shared.Prov
            address?.text = Globals.shared.Adress
        }
        super.onResume()

    }
}