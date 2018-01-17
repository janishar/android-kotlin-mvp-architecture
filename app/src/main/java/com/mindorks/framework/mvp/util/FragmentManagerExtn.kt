package com.mindorks.framework.mvp.util

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.mindorks.framework.mvp.R


/**
 * Created by jyotidubey on 17/01/18.
 */

internal fun FragmentManager.removeFragment(tag: String,
                                   slideIn: Int = R.anim.slide_left,
                                   slideOut: Int = R.anim.slide_right) {
    this.beginTransaction()
            .disallowAddToBackStack()
            .setCustomAnimations(slideIn, slideOut)
            .remove(this.findFragmentByTag(tag))
            .commitNow()
}

internal fun FragmentManager.addFragment(containerViewId: Int,
                                fragment: Fragment,
                                tag: String,
                                slideIn: Int = R.anim.slide_left,
                                slideOut: Int = R.anim.slide_right) {
    this.beginTransaction().disallowAddToBackStack()
            .setCustomAnimations(slideIn, slideOut)
            .add(containerViewId, fragment, tag)
            .commit()
}

