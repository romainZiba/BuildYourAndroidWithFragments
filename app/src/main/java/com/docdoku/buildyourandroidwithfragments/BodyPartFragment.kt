package com.docdoku.buildyourandroidwithfragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

/**
 * Created by romainz on 26/03/18.
 */
class BodyPartFragment : Fragment() {

    private var mImageIds: List<Int> = listOf()

    fun setImageIds(imageIds: List<Int>) {
        mImageIds = imageIds
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater?.inflate(R.layout.fragment_body_part, container, false)
        val imageView = rootView?.findViewById(R.id.iv_body_part) as ImageView
        if (mImageIds.isNotEmpty()) {
            imageView.setImageResource(mImageIds[0])
        }
        return rootView
    }
}