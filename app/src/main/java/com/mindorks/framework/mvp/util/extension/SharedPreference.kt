package com.mindorks.framework.mvp.util.extension

import android.content.SharedPreferences

/**
 * Created by jyotidubey on 24/01/18.
 */
inline fun SharedPreferences.edit(block: SharedPreferences.Editor.() -> Unit) {
    val editor = edit()
    editor.block()
    editor.apply()
}

