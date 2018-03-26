package com.docdoku.buildyourandroidwithfragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import java.util.ArrayList

/**
 * Created by romainz on 26/03/18.
 */
class BodyPartFragment : Fragment() {

    companion object {
        private val IMAGE_IDS = "IMAGE_IDS"
        private val IMAGE_INDEX = "INDEX"
    }

    private var mImageIds: List<Int> = listOf()
    private var mImageIndex: Int = 0

    fun setImageIds(imageIds: List<Int>) {
        mImageIds = imageIds
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val imageIds = savedInstanceState?.getIntegerArrayList(IMAGE_IDS)
        if (imageIds != null) {
            mImageIds = imageIds.toList()
        }
        val imageIndex = savedInstanceState?.getInt(IMAGE_INDEX)
        if (imageIndex != null) {
            mImageIndex = imageIndex
        }

        val rootView = inflater?.inflate(R.layout.fragment_body_part, container, false)
        val imageView = rootView?.findViewById(R.id.iv_body_part) as ImageView
        if (mImageIds.isNotEmpty()) {
            imageView.setImageResource(mImageIds[mImageIndex])
            imageView.setOnClickListener {
                // Increment position as long as the index remains <= the size of the image ids list
                if (mImageIndex < mImageIds.size - 1) {
                    mImageIndex++
                } else {
                    mImageIndex = 0
                }
                imageView.setImageResource(mImageIds[mImageIndex])
            }
        }
        return rootView
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putIntegerArrayList(IMAGE_IDS, mImageIds as ArrayList<Int>)
        outState?.putInt(IMAGE_INDEX, mImageIndex)
    }

    fun setImageIndex(index: Int) {
        mImageIndex = index
    }
}