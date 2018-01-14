package com.mindorks.framework.mvp.ui.feed.opensource.view

import com.mindorks.framework.mvp.data.network.OpenSource
import com.mindorks.framework.mvp.ui.base.view.MVPView

/**
 * Created by jyotidubey on 14/01/18.
 */
interface OpenSourceView : MVPView {
    fun displayOpenSourceList(blogs: List<OpenSource>?)

}