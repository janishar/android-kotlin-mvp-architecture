package com.mindorks.framework.mvp.util

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager

/**
 * Created by jyotidubey on 09/01/18.
 */
object ScreenUtils {

    fun getScreenWidth(context: Context): Int {
        val windowManager = context
                .getSystemService(Context.WINDOW_SERVICE) as WindowManager
        windowManager.let {
            val dm = DisplayMetrics()
            it.defaultDisplay.getMetrics(dm)
            return dm.widthPixels
        }
    }

    fun getScreenHeight(context: Context): Int {
        val windowManager = context
                .getSystemService(Context.WINDOW_SERVICE) as WindowManager
        windowManager.let {
            val dm = DisplayMetrics()
            it.defaultDisplay.getMetrics(dm)
            return dm.heightPixels
        }
    }
}
