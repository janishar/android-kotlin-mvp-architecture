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


    override fun getItemCount() = openSourceListItems.size

    override fun onBindViewHolder(holder: OpenSourceViewHolder, position: Int) = holder.let {
        it.clear()
        it.onBind(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) = OpenSourceViewHolder(LayoutInflater.from(parent?.context)
            .inflate(R.layout.item_open_source_list, parent, false))


    internal fun addOpenSourcesToList(OpenSources: List<OpenSource>) {
        this.openSourceListItems.addAll(OpenSources)
        notifyDataSetChanged()
    }

    inner class OpenSourceViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun clear() {
            itemView.coverImageView.setImageDrawable(null)
            itemView.titleTextView.text = ""
            itemView.contentTextView.text = ""
        }

        fun onBind(position: Int) {
            val openSource = openSourceListItems[position]
            loadCoverPageImage(openSource)
            setDataToFields(openSource)
            setItemClickListener(openSource)
        }

        private fun setItemClickListener(openSource: OpenSource) {
            itemView.setOnClickListener {
                openSource.projectUrl?.let {
                    try {
                        val intent = Intent()
                        intent.apply { action = Intent.ACTION_VIEW }
                                .apply { data = Uri.parse(it) }
                                .addCategory(Intent.CATEGORY_BROWSABLE)
                        itemView.context.startActivity(intent)
                    } catch (e: Exception) {
                    }
                }
            }
        }

        private fun setDataToFields(openSource: OpenSource) {
            openSource.title?.let { itemView.titleTextView.text = it }
            openSource.description?.let { itemView.contentTextView.text = it }
        }

        private fun loadCoverPageImage(openSource: OpenSource) {
            openSource.coverImgUrl?.let {
                Glide.with(itemView.context)
                        .load(it)
                        .asBitmap()
                        .centerCrop()
                        .into(itemView.coverImageView)
            }

        }
    }
}
