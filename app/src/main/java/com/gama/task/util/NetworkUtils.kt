package com.gama.task.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

/**
 * A helper class that check the connection to the internet
 */

object NetworkUtils {

    /**
     * check if the device is connected or not.
     *
     * @param context Context the app context
     * @return Boolean? true if connected, false otherwise.
     */
    fun isNetworkConnected(context: Context): Boolean? {
        var isConnected: Boolean? = false // Initial Value
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        if (activeNetwork != null && activeNetwork.isConnected)
            isConnected = true
        return isConnected
    }
}
