package com.mindorks.framework.mvp.ui.feed.opensource.view

import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.mindorks.framework.mvp.R
import com.mindorks.framework.mvp.data.network.OpenSource
import kotlinx.android.synthetic.main.item_open_source_list.view.*


/**
 * Created by jyotidubey on 14/01/18.
 */
class OpenSourceAdapter(openSourceListItems: MutableList<OpenSource>) : RecyclerView.Adapter<OpenSourceAdapter.OpenSourceViewHolder>() {

    private val openSourceListItems: MutableList<OpenSource> = openSourceListItems

    override fun getItemCount(): Int {
        return this.openSourceListItems.size
    }

    override fun onBindViewHolder(holder: OpenSourceViewHolder, position: Int) {
        holder.clear()
        holder.onBind(position)
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): OpenSourceViewHolder {
        return OpenSourceViewHolder(LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_open_source_list, parent, false))
    }

    internal fun addOpenSourcesToList(OpenSources: List<OpenSource>) {
        this.openSourceListItems.addAll(OpenSources)
        notifyDataSetChanged()
    }

    inner class OpenSourceViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun clear() {
            itemView.cover_image_view.setImageDrawable(null)
            itemView.title_text_view.text = ""
            itemView.content_text_view.text = ""
        }

        fun onBind(position: Int) {
            val openSource = openSourceListItems[position]
            if (openSource.coverImgUrl != null) {
                Glide.with(itemView.context)
                        .load(openSource.coverImgUrl)
                        .asBitmap()
                        .centerCrop()
                        .into(itemView.cover_image_view)
            }
            openSource.title?.let { itemView.title_text_view.text = it }
            openSource.description?.let { itemView.content_text_view.text = it }

            itemView.setOnClickListener {
                openSource.projectUrl?.let {
                    try {
                        val intent = Intent()
                        intent.action = Intent.ACTION_VIEW
                        intent.addCategory(Intent.CATEGORY_BROWSABLE)
                        intent.data = Uri.parse(it)
                        itemView.context.startActivity(intent)
                    } catch (e: Exception) {
                    }
                }

            }
        }
    }
}
