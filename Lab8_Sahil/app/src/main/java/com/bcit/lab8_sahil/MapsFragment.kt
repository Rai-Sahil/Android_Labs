package com.bcit.lab8_sahil

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.text.DecimalFormat
import kotlin.properties.Delegates

lateinit var ll : LatLng

class MapsFragment : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->
        val df = DecimalFormat("#.##")

        try {
            googleMap.setOnMapLongClickListener {
                googleMap.clear()
                googleMap.addMarker(MarkerOptions().position(it).title("Marker"))
                val latitude = df.format(it.latitude).toDouble()
                val longitude = df.format(it.longitude).toDouble()
                ll = LatLng(latitude, longitude)

            }
        }catch (e: UninitializedPropertyAccessException){
            println("message : " + e.message)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }


}