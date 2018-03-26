package com.docdoku.buildyourandroidwithfragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.docdoku.buildyourandroidwithfragments.data.AndroidImageAssets
import kotlinx.android.synthetic.main.fragment_master_list.view.*

class MasterListFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.fragment_master_list, container, false)
        val gridLayoutManager = GridLayoutManager(context, 3)
        rootView.rv_master_list_fragment.layoutManager = gridLayoutManager

        rootView.rv_master_list_fragment.adapter = MasterListAdapter(context, AndroidImageAssets.all)
        return rootView
    }
}
