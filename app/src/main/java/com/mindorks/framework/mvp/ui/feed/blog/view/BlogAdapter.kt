package com.mindorks.framework.mvp.ui.feed.blog.view

import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mindorks.framework.mvp.R
import com.mindorks.framework.mvp.data.network.Blog
import com.mindorks.framework.mvp.util.loadImage
import kotlinx.android.synthetic.main.item_blog_list.view.*


/**
 * Created by jyotidubey on 14/01/18.
 */
class BlogAdapter(private val blogListItems: MutableList<Blog>) : RecyclerView.Adapter<BlogAdapter.BlogViewHolder>() {

    override fun getItemCount() = this.blogListItems.size

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) = holder.let {
        it.clear()
        it.onBind(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) = BlogViewHolder(LayoutInflater.from(parent?.context)
            .inflate(R.layout.item_blog_list, parent, false))

    internal fun addBlogsToList(blogs: List<Blog>) {
        this.blogListItems.addAll(blogs)
        notifyDataSetChanged()
    }

    inner class BlogViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun clear() {
            itemView.coverImageView.setImageDrawable(null)
            itemView.titleTextView.text = ""
            itemView.contentTextView.text = ""
        }

        fun onBind(position: Int) {

            val (title, author, date, description, coverPageUrl, blogUrl) = blogListItems[position]

            inflateData(title, author, date, description, coverPageUrl)
            setItemClickListener(blogUrl)
        }

        private fun setItemClickListener(blogUrl: String?) {
            itemView.setOnClickListener {
                blogUrl?.let {
                    try {
                        val intent = Intent()
                        // using "with" as an example
                        with(intent) {
                            action = Intent.ACTION_VIEW
                            data = Uri.parse(it)
                            addCategory(Intent.CATEGORY_BROWSABLE)
                        }
                        itemView.context.startActivity(intent)
                    } catch (e: Exception) {
                    }
                }

            }
        }

        private fun inflateData(title: String?, author: String?, date: String?, description: String?, coverPageUrl: String?) {
            title?.let { itemView.titleTextView.text = it }
            author?.let { itemView.authorTextView.text = it }
            date?.let { itemView.dateTextView.text = it }
            description?.let { itemView.contentTextView.text = it }
            coverPageUrl?.let {
                itemView.coverImageView.loadImage(it)
            }
        }

    }
}
