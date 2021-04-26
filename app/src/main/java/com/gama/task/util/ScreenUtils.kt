package com.gama.task.util

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.os.Build
import android.util.DisplayMetrics
import android.view.WindowManager

/**
 * A util class that calculate the dimensions of the screen
 */
object ScreenUtils {

    /**
     * Get the screen width in px.
     *
     * @param context Context the app context.
     * @return Int the screen width in px.
     *
     * @see getScreenHeight
     */
    fun getScreenWidth(context: Context): Int {
        val windowManager = context
            .getSystemService(Context.WINDOW_SERVICE) as WindowManager
        windowManager.let {
            val dm = DisplayMetrics()
            it.defaultDisplay.getMetrics(dm)
            return dm.widthPixels
        }
    }

    /**
     * Get the screen height in px.
     *
     * @param context Context the app context.
     * @return Int the screen height in px.
     *
     * @see getScreenWidth
     */
    fun getScreenHeight(context: Context): Int {
        val windowManager = context
            .getSystemService(Context.WINDOW_SERVICE) as WindowManager
        windowManager.let {
            val dm = DisplayMetrics()
            it.defaultDisplay.getMetrics(dm)
            return dm.heightPixels
        }
    }

    /**
     * calculate the ratio of height/width.
     *
     * @param context Context the app context.
     * @return Double the ratio
     */
    fun getScreenAspectRatio(context: Context): Double {
        val resources = context.resources
        val config = resources.configuration
        val dm = resources.displayMetrics

        val screenWidthInPixels = config.screenWidthDp.toDouble() * dm.density
        var screenHeightInPixels = screenWidthInPixels * dm.heightPixels / dm.widthPixels


        if (isNavBarShown(context.resources))
            screenHeightInPixels += getNavigationBarHeight(context)

        return screenHeightInPixels / screenWidthInPixels

    }


    /**
     * check if the bottomNavBar is displayed or not
     * @param resources Resources the app or activity resources.
     * @return Boolean true if it's displayed, false otherwise.
     */
    fun isNavBarShown(resources: Resources): Boolean {
        val id = resources.getIdentifier("config_showNavigationBar", "bool", "android")
        return id > 0 && resources.getBoolean(id)
    }

    /**
     * Get the height of bottomNavBar in px.
     *
     * @param context Context
     * @return Int the height of bottomNavBar
     */
    fun getNavigationBarHeight(context: Context): Int {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            val metrics = DisplayMetrics()
            (context as Activity).windowManager.defaultDisplay.getMetrics(metrics)
            val usableHeight = metrics.heightPixels
            context.windowManager.defaultDisplay.getRealMetrics(metrics)
            val realHeight = metrics.heightPixels
            return if (realHeight > usableHeight)
                realHeight - usableHeight
            else
                0
        }
        return 0
    }
}
