package com.docdoku.buildyourandroidwithfragments

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.ImageView


/**
 * Custom adapter class that displays a list of Android images in a RecyclerView
 */
class MasterListAdapter(private val mContext: Context,
                        private val mImageIds: List<Int>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val mView = ImageView(mContext)
        mView.adjustViewBounds = true
        mView.scaleType = ImageView.ScaleType.CENTER_CROP
        mView.setPadding(8, 8, 8, 8)
        return ImageViewHolder(mView)
    }

    override fun getItemCount(): Int {
        return mImageIds.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        (holder?.itemView as ImageView).setImageResource(mImageIds[position])
    }

    class ImageViewHolder(mView: ImageView) : RecyclerView.ViewHolder(mView)
}
