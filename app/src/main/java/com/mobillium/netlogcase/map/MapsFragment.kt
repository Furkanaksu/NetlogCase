package com.mobillium.netlogcase.map

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.mobillium.netlogcase.R


class MapsFragment : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->

        val sydney = LatLng(41.112663, 29.021330)
        googleMap.addMarker(MarkerOptions().position(sydney).title("Marker in İstanbul"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        googleMap.animateCamera(
            CameraUpdateFactory.newLatLngZoom(
                LatLng(
                    41.112663,
                    29.021330
                ), 15.0f
            )
        )
    }

    private val mMap: GoogleMap? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val page = inflater.inflate(R.layout.fragment_maps, container, false)

        val map = page.findViewById<View>(R.id.map)
        val frame = page.findViewById<FrameLayout>(R.id.frame)

        map.setOnClickListener {
            val i = Intent(context, MapActivity::class.java)
            startActivity(i)
        }

        frame.setOnClickListener {
            val i = Intent(context, MapActivity::class.java)
            startActivity(i)
        }

        return page
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}