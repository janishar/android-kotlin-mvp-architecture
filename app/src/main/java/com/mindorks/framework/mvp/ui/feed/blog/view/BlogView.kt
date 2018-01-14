package com.mindorks.framework.mvp.ui.feed.blog.view

import com.mindorks.framework.mvp.data.network.Blog
import com.mindorks.framework.mvp.ui.base.view.MVPView

/**
 * Created by jyotidubey on 13/01/18.
 */
interface BlogView : MVPView {
    fun displayBlogList(blogs: List<Blog>?)
}