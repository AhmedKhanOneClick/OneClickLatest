/*
 * Copyright (C) 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gama.task.ui.fragments.sidemenu.Map

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.content.res.Resources
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.gama.task.R
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationListener
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import java.io.IOException
import java.util.*

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences

import android.location.LocationManager

import android.os.Looper
import android.provider.Settings
import android.widget.TextView
import com.gama.task.ui.main.MainActivity
import com.gama.task.util.extensions.openActivity

import com.google.android.gms.location.*

//This class allows you to interact with the map by adding markers, styling its appearance and
// displaying the user's location.
class MapsActivity : AppCompatActivity(), OnMapReadyCallback, LocationListener,
    GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    var marker: Marker? = null
    var poiMarker: Marker? = null
    private lateinit var map: GoogleMap
    private val TAG = MapsActivity::class.java.simpleName
    private val REQUEST_LOCATION_PERMISSION = 1
    internal lateinit var mLastLocation: Location
    internal var mCurrLocationMarker: Marker? = null
    internal var mGoogleApiClient: GoogleApiClient? = null
    internal lateinit var mLocationRequest: LocationRequest
    val zoomLevel = 15f
    val overlaySize = 100f
    lateinit var mFusedLocationClient: FusedLocationProviderClient
    var latitude:Double = 0.0
     var longitude:Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near the Googleplex.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @SuppressLint("MissingPermission")
    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        //These coordinates represent the lattitude and longitude of the Googleplex.

//        val latitude = 30.97078793734332
//        val longitude = 31.168833018137153



//        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if (ContextCompat.checkSelfPermission(this,
//                    Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//                buildGoogleApiClient()
//                map!!.isMyLocationEnabled = true
//            }
//        } else {
//            buildGoogleApiClient()
//            map!!.isMyLocationEnabled = true
//        }
        val sharedPreferencesmap: SharedPreferences = this.getSharedPreferences("map",Context.MODE_PRIVATE)
        val prefsEditor = sharedPreferencesmap.edit()
        val serializedObject: String = sharedPreferencesmap.getString("latitude", "")!!
if(serializedObject.isBlank()){
        if (checkPermissions()) {
            if (isLocationEnabled()) {
                buildGoogleApiClient()
                map!!.isMyLocationEnabled = true
                mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
                mFusedLocationClient.lastLocation.addOnCompleteListener(this) { task ->
                    var location: Location? = task.result
                    if (location == null) {
                        requestNewLocationData()
                    } else {
                        latitude= location.latitude
                        longitude = location.longitude
                        Log.d(TAG, "onMapReady: "+latitude+" "+longitude)
                        val geocoder = Geocoder(this, Locale.getDefault())
                        val addresses = geocoder.getFromLocation(latitude, longitude, 1)
                        val obj = addresses[0]
                        val homeLatLng = LatLng(latitude, longitude)
                        map.moveCamera(CameraUpdateFactory.newLatLngZoom(homeLatLng, zoomLevel))
                        map.addMarker(MarkerOptions().position(homeLatLng).title(""+obj.getAdminArea()))

                        val googleOverlay = GroundOverlayOptions()
                            .image(BitmapDescriptorFactory.fromResource(R.drawable.oneclick_logo))
                            .position(homeLatLng, overlaySize)
                        map.addGroundOverlay(googleOverlay)

//        setMapLongClick(map)
                        setPoiClick(map)
                        setMapStyle(map)
                        enableMyLocation()
                    }
                }
            } else {
                Toast.makeText(this, "Turn on location", Toast.LENGTH_LONG).show()
                val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                startActivity(intent)
            }
        } else {
            requestPermissions()
        }}else{

    val latitude:Double = sharedPreferencesmap.getString("latitude","")!!.toDouble()
    val longitude:Double = sharedPreferencesmap.getString("longitude","")!!.toDouble()
    val zoomLevel = 15f
    val overlaySize = 100f

    val homeLatLng = LatLng(latitude, longitude)
    map.moveCamera(CameraUpdateFactory.newLatLngZoom(homeLatLng, zoomLevel))
    map.addMarker(MarkerOptions().position(homeLatLng))

    val googleOverlay = GroundOverlayOptions()
        .image(BitmapDescriptorFactory.fromResource(R.drawable.oneclick_logo))
        .position(homeLatLng, overlaySize)
    map.addGroundOverlay(googleOverlay)

//        setMapLongClick(map)
    setPoiClick(map)
//    setMapStyle(map)
    enableMyLocation()
        }
//         latitude =  mLastLocation.altitude
//         longitude =  mLastLocation.longitude


    }

    // Initializes contents of Activity's standard options menu. Only called the first time options
    // menu is displayed.
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.map_options, menu)
        return true
    }

    // Called whenever an item in your options menu is selected.
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        // Change the map type based on the user's selection.
        R.id.normal_map -> {
            map.mapType = GoogleMap.MAP_TYPE_NORMAL
            true
        }
        R.id.hybrid_map -> {
            map.mapType = GoogleMap.MAP_TYPE_HYBRID
            true
        }
        R.id.satellite_map -> {
            map.mapType = GoogleMap.MAP_TYPE_SATELLITE
            true
        }
        R.id.terrain_map -> {
            map.mapType = GoogleMap.MAP_TYPE_TERRAIN
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    // Called when user makes a long press gesture on the map.
    private fun setMapLongClick(map: GoogleMap) {

        map.setOnMapLongClickListener { latLng ->
            if (marker != null) {
                marker!!.remove();
            }
            // A Snippet is Additional text that's displayed below the title.
            val snippet = String.format(
                Locale.getDefault(),
                "Lat: %1$.5f, Long: %2$.5f",
                latLng.latitude,
                latLng.longitude
            )
            marker =map.addMarker(
                MarkerOptions()
                    .position(latLng)
                    .title(getString(R.string.dropped_pin))
                    .snippet(snippet)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
            )
        }
    }

    // Places a marker on the map and displays an info window that contains POI name.
    private fun setPoiClick(map: GoogleMap) {

        map.setOnPoiClickListener { poi ->
            if (poiMarker != null) {
                poiMarker!!.remove();
            }
            // A Snippet is Additional text that's displayed below the title.
//            val snippet = String.format(
//                Locale.getDefault(),
//                "Lat: %1$.5f, Long: %2$.5f",
//                poi.latLng
//            )
             poiMarker = map.addMarker(
                MarkerOptions()
                    .position(poi.latLng)
                    .title(poi.name)
//                    .snippet(snippet)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
            )

           poiMarker.let {
               it!!.showInfoWindow()
           }
            val sharedPreferencesmap: SharedPreferences = this.getSharedPreferences("map",Context.MODE_PRIVATE)
            val editor:SharedPreferences.Editor =  sharedPreferencesmap.edit()
            editor.putString("latitude",""+poi.latLng.latitude)
            editor.putString("longitude",""+poi.latLng.longitude)
            editor.putString("name",""+poi.name)
            editor.apply()
            editor.commit()
        }
    }

    // Allows map styling and theming to be customized.
    private fun setMapStyle(map: GoogleMap) {
        try {
            // Customize the styling of the base map using a JSON object defined
            // in a raw resource file.
            val success = map.setMapStyle(
                MapStyleOptions.loadRawResourceStyle(
                    this,
                    R.raw.map_style
                )
            )

            if (!success) {
                Log.e(TAG, "Style parsing failed.")
            }
        } catch (e: Resources.NotFoundException) {
            Log.e(TAG, "Can't find style. Error: ", e)
        }
    }

    // Checks that users have given permission
    private fun isPermissionGranted() : Boolean {
       return ContextCompat.checkSelfPermission(
           this,
           Manifest.permission.ACCESS_FINE_LOCATION
       ) == PackageManager.PERMISSION_GRANTED
    }

    // Checks if users have given their location and sets location enabled if so.
    @SuppressLint("MissingPermission")
    private fun enableMyLocation() {
        if (isPermissionGranted()) {
            map.isMyLocationEnabled = true
        }
        else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf<String>(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_LOCATION_PERMISSION
            )
        }
    }

    // Callback for the result from requesting permissions.
    // This method is invoked for every call on requestPermissions(android.app.Activity, String[],
    // int).
    @SuppressLint("MissingSuperCall")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        // Check if location permissions are granted and if so enable the
        // location data layer.
        if (requestCode == REQUEST_LOCATION_PERMISSION) {
            if (grantResults.contains(PackageManager.PERMISSION_GRANTED)) {
                enableMyLocation()

            }
        }
    }
    fun searchLocation(view: View) {
        val locationSearch: EditText = findViewById<EditText>(R.id.editText)
        lateinit var location: String
        location = locationSearch.text.toString()
        var addressList: List<Address>? = null

        if (location == null || location == "") {
            Toast.makeText(applicationContext,"provide location", Toast.LENGTH_SHORT).show()
        }
        else {
            val geoCoder = Geocoder(this)
            try {
                addressList = geoCoder.getFromLocationName(location, 1)

            } catch (e: IOException) {
                e.printStackTrace()
            }
            if (addressList!!.size > 0) {
                val address = addressList!![0]
//            Log.d("TAG", "searchLocation: "+   address.getAddressLine())
                Log.d("TAG", "searchLocation: " + address.countryName)
                Log.d("TAG", "searchLocation: " + address.maxAddressLineIndex)
                Log.d("TAG", "searchLocation: " + address.getThoroughfare())
                Log.d("TAG", "searchLocation: " + address.countryName+address.getAdminArea()+locationSearch.text.toString())
                val latLng = LatLng(address.latitude, address.longitude)
//                mMap!!.addMarker(MarkerOptions().position(latLng).title(location))
//                mMap!!.animateCamera(CameraUpdateFactory.newLatLng(latLng))
//                mMap!!.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f))

                if (poiMarker != null) {
                    poiMarker!!.remove();
                }
                // A Snippet is Additional text that's displayed below the title.
//            val snippet = String.format(
//                Locale.getDefault(),
//                "Lat: %1$.5f, Long: %2$.5f",
//                poi.latLng
//            )
                poiMarker = map.addMarker(
                    MarkerOptions()
                        .position(latLng)
                        .title(""+locationSearch.text)
//                    .snippet(snippet)
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                )
               map.animateCamera(CameraUpdateFactory.newLatLng(latLng))
                 map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f))

                poiMarker.let {
                    it!!.showInfoWindow()
                }




                Toast.makeText(
                    applicationContext,
                    address.latitude.toString() + " " + address.longitude,
                    Toast.LENGTH_LONG
                ).show()
                val sharedPreferencesmap: SharedPreferences = this.getSharedPreferences("map",Context.MODE_PRIVATE)
                val editor:SharedPreferences.Editor =  sharedPreferencesmap.edit()
                editor.putString("latitude",""+address.latitude)
                editor.putString("longitude",""+address.longitude)
                editor.putString("name",""+address.subAdminArea)
                editor.apply()
                editor.commit()
            }else{
                Toast.makeText(
                    applicationContext,
                    "Invalid location",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
    @Synchronized
    protected fun buildGoogleApiClient() {
        mGoogleApiClient = GoogleApiClient.Builder(this)
            .addConnectionCallbacks(this)
            .addOnConnectionFailedListener(this)
            .addApi(LocationServices.API).build()
        mGoogleApiClient!!.connect()
    }

    override fun onConnected(bundle: Bundle?) {

        mLocationRequest = LocationRequest()
        mLocationRequest.interval = 1000
        mLocationRequest.fastestInterval = 1000
        mLocationRequest.priority = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            LocationServices.getFusedLocationProviderClient(this)
        }
    }

    override fun onConnectionSuspended(i: Int) {

    }

    override fun onLocationChanged(location: Location) {

        mLastLocation = location
        if (mCurrLocationMarker != null) {
            mCurrLocationMarker!!.remove()
        }
        //Place current location marker
        val latLng = LatLng(location.latitude, location.longitude)
        val markerOptions = MarkerOptions()
        markerOptions.position(latLng)
        markerOptions.title("Current Position")
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
        mCurrLocationMarker = map!!.addMarker(markerOptions)

        //move map camera
        map!!.moveCamera(CameraUpdateFactory.newLatLng(latLng))
        map!!.animateCamera(CameraUpdateFactory.zoomTo(11f))
        val googleOverlay = GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.oneclick_logo))
            .position(latLng, overlaySize)
        map.addGroundOverlay(googleOverlay)
        //stop location updates
        if (mGoogleApiClient != null) {
            LocationServices.getFusedLocationProviderClient(this)
        }

    }

    override fun onConnectionFailed(connectionResult: ConnectionResult) {

    }

    @SuppressLint("MissingPermission")
    private fun requestNewLocationData() {
        var mLocationRequest = LocationRequest()
        mLocationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        mLocationRequest.interval = 0
        mLocationRequest.fastestInterval = 0
        mLocationRequest.numUpdates = 1

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        mFusedLocationClient!!.requestLocationUpdates(
            mLocationRequest, mLocationCallback,
            Looper.myLooper()
        )
    }

    private val mLocationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            var mLastLocation: Location = locationResult.lastLocation
            }
    }

    private fun isLocationEnabled(): Boolean {
        var locationManager: LocationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
            LocationManager.NETWORK_PROVIDER
        )
    }

    private fun checkPermissions(): Boolean {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            return true
        }
        return false
    }

    private fun requestPermissions() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION),
            42
        )
    }

    override fun onBackPressed() {
        openActivity(MainActivity::class.java, true)
        super.onBackPressed()
    }


}
