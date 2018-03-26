package com.docdoku.buildyourandroidwithfragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.docdoku.buildyourandroidwithfragments.data.AndroidImageAssets
import kotlinx.android.synthetic.main.fragment_master_list.view.*

class MasterListFragment : Fragment() {
    
    interface OnImageClickListener {
        fun onImageSelected(position: Int)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.fragment_master_list, container, false)
        val gridLayoutManager = GridLayoutManager(context, 3)
        rootView.rv_master_list_fragment.layoutManager = gridLayoutManager

        rootView.rv_master_list_fragment.adapter = MasterListAdapter(activity, AndroidImageAssets.all)
        return rootView
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        try {
            context as OnImageClickListener
        } catch (e: ClassCastException) {
            throw ClassCastException(context!!.toString() + " must implement OnImageClickListener")
        }
    }
}
