package com.mindorks.framework.mvp.util

import android.util.Patterns

/**
 * Created by jyotidubey on 11/01/18.
 */
class CommonUtil {
    companion object {
        fun isValidEmail(email: String): Boolean {
            return Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }
    }
}