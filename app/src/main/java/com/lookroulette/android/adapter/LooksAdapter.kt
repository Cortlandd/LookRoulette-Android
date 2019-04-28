package com.lookroulette.android.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.lookroulette.android.R


import com.lookroulette.android.content.LooksContent.LookItem
import com.lookroulette.android.fragments.LooksFragment

import kotlinx.android.synthetic.main.fragment_look.view.*
import org.jetbrains.anko.image
import org.jetbrains.anko.imageResource

/**
 * [RecyclerView.Adapter] that can display a [LookItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class LooksAdapter(private val mValues: List<LookItem>, private val mListener: LooksFragment.OnListFragmentInteractionListener?)
    : RecyclerView.Adapter<LooksAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as LookItem
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_look, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mIdView.text = item.id
        holder.mYouTubeURLView.text = item.youtubeURL
        holder.mYouTubeThumbnailView.imageResource = item.youtubeThumbnail!!

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView = mView.item_number
        val mYouTubeURLView: TextView = mView.item_youtube_url
        val mYouTubeThumbnailView: ImageView = mView.item_youtube_thumbnail

        override fun toString(): String {
            return super.toString() + " '" + mYouTubeURLView.text + "'"
        }
    }


}
