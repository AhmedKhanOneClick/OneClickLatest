/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gama.task.binding

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestListener
import com.gama.task.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import javax.inject.Inject

/**
 * Binding adapters that work with a fragment instance.
 */
class FragmentBindingAdapters @Inject constructor(val fragment: Fragment) {

    /**
     * Extension function to set img to [ImageView] from url using [Glide](https://github.com/bumptech/glide).
     *
     * Because it's a [BindingAdapter](https://developer.android.com/topic/libraries/data-binding/binding-adapters), it can be used as a XML attribute:
     *  ```xml
     *      <ImageView
     *       ...
     *       app:imageUrl:"@{the img url}"
     *       app:placeHolder="@{the placeHolder img}"
     *       app:imageRequestListener="@{the listener for img loading}"/>
     *  ```
     *
     * @receiver [ImageView]
     * @param url String? the url of the img
     * @param placeHolder Drawable? the img to be displayed until the img loaded or if the loading failed
     * @param listener RequestListener<Bitmap>? listener for img loading
     */
    @BindingAdapter(value = ["imageUrl", "placeHolder", "imageRequestListener"], requireAll = false)
    fun ImageView.bindImage(
        url: String?,
        placeHolder: Drawable?,
        listener: RequestListener<Bitmap>?
    ) {
        Glide.with(fragment)
            .asBitmap()
            .load(url)
            .placeholder(placeHolder)
            .error(placeHolder)
            .fallback(placeHolder)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .listener(listener)
            .into(this)
    }


    /**
     * Extension function to set gif loader img to [ImageView] using [Glide](https://github.com/bumptech/glide).
     *
     * Because it's a [BindingAdapter](https://developer.android.com/topic/libraries/data-binding/binding-adapters), it can be used as a XML attribute:
     *  ```xml
     *      <ImageView
     *       ...
     *       app:loadingImg:"@{true}"/>
     *  ```
     *
     * @receiver [ImageView]
     * @param isLoader Boolean? true to set loader img,false otherwise
     */
    @BindingAdapter("loadingImg")
    fun ImageView.loadGifImg(isLoader: Boolean?) {

        if (isLoader != true)
            return

        Glide.with(fragment)
//            .asGif()
//            .load(R.raw.loader_anim)
            .asBitmap()
//            .load(R.drawable.waiting)
            .load(R.raw.loader_anim)
            .into(this)
    }


    /**
     * Make view work as back/up icon so if clicked:
     * * dismiss the dialog if [fragment] is a dialog fragment.
     * * navigateUp otherwise.
     *
     * Because it's a [BindingAdapter](https://developer.android.com/topic/libraries/data-binding/binding-adapters), it can be used as a XML attribute:
     *  ```xml
     *      <View
     *       ...
     *       app:isBackIcon:"@{true}"/>
     *  ```
     *
     * @receiver [View]
     * @param isBackIcon Boolean to set click listener of this view to navigate up
     */
    @BindingAdapter("isBackIcon")
    fun View.setBackBehavior(isBackIcon: Boolean) {

        if (isBackIcon)
            setOnClickListener {
                if (fragment is DialogFragment)
                    fragment.dismissAllowingStateLoss()
                else
                    fragment.findNavController().navigateUp()
            }
    }

    /**
     * Extension function to init the [MapView], add marker and move camera to specific lat, lng.
     *
     * Because it's a [BindingAdapter](https://developer.android.com/topic/libraries/data-binding/binding-adapters), it can be used as a XML attribute:
     *  ```xml
     *      <com.google.android.gms.maps.MapView
     *       ...
     *       app:lat:"@{latitude of the location}"
     *       app:lng:"@{longitude of the location}"/>
     *  ```
     *
     * @receiver [MapView]
     * @param lat Double? the latitude of the location
     * @param lng Double? the longitude of the location
     */
    @BindingAdapter(value = ["lat", "lng"], requireAll = true)
    fun MapView.setLocation(lat: Double?, lng: Double?) {

        if (lat == null || lng == null)
            return



        getMapAsync { googleMap ->
            val latLng = LatLng(lat, lng)

            googleMap.addMarker(MarkerOptions().position(latLng))
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng))
        }

        setOnClickListener { v: View ->
            val gmmIntentUri = Uri.parse("geo:$lat,$lng")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            if (mapIntent.resolveActivity(v.context.packageManager) != null) {
                v.context.startActivity(mapIntent)
            }
        }
    }

}

