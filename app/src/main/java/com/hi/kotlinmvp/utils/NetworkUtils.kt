package com.hi.kotlinmvp.utils

import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by Vishal Patel on 05/12/19.
 */
object NetworkUtils {
    /**
     * This method is used to check internet connectivity of device.
     * This method returns true if connectivity exist else returns
     * false
     */
    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo

        return networkInfo != null && networkInfo.isAvailable && networkInfo.isConnected
    }
}
