package com.docdoku.buildyourandroidwithfragments

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import com.docdoku.buildyourandroidwithfragments.data.AndroidImageAssets
import kotlinx.android.synthetic.main.fragment_master_list.*

/**
 * Created by romainz on 26/03/18.
 */
class MainActivity : AppCompatActivity(), MasterListFragment.OnImageClickListener {

    companion object {
        const val HEAD_INDEX_KEY = "headIndex"
        const val BODY_INDEX_KEY = "bodyIndex"
        const val LEGS_INDEX_KEY = "legIndex"
    }

    private var headIndex: Int = 0
    private var bodyIndex: Int = 0
    private var legIndex: Int = 0
    private var mTwoPane = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        build_button.setOnClickListener { startBuildAndroidActivity() }

        headIndex = savedInstanceState?.getInt(HEAD_INDEX_KEY) ?: 0
        bodyIndex = savedInstanceState?.getInt(BODY_INDEX_KEY) ?: 0
        legIndex = savedInstanceState?.getInt(LEGS_INDEX_KEY) ?: 0

        if (findViewById<LinearLayout>(R.id.built_android_linear_layout) != null) {
            mTwoPane = true
            build_button.visibility = View.GONE

            if (savedInstanceState == null) {
                val headFragment = BodyPartFragment()
                headFragment.setImageIds(AndroidImageAssets.heads)
                val bodyFragment = BodyPartFragment()
                bodyFragment.setImageIds(AndroidImageAssets.bodies)
                val legsFragment = BodyPartFragment()
                legsFragment.setImageIds(AndroidImageAssets.legs)
                supportFragmentManager.beginTransaction()
                        .add(R.id.head_fragment_container, headFragment)
                        .add(R.id.body_fragment_container, bodyFragment)
                        .add(R.id.legs_fragment_container, legsFragment)
                        .commit()
            }
        } else {
            mTwoPane = false
        }
    }

    override fun onImageSelected(position: Int) {
        Toast.makeText(this, "Position clicked = $position", Toast.LENGTH_SHORT).show()
        val bodyPartNumber = position / 12
        val listIndex = position - 12 * bodyPartNumber

        if (mTwoPane) {
            val newFragment = BodyPartFragment()
            when (bodyPartNumber) {
                0 -> {
                    newFragment.setImageIds(AndroidImageAssets.heads)
                    newFragment.setImageIndex(listIndex)
                    // Replace the old head fragment with a new one
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.head_fragment_container, newFragment)
                            .commit()
                }
                1 -> {
                    newFragment.setImageIds(AndroidImageAssets.bodies)
                    newFragment.setImageIndex(listIndex)
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.body_fragment_container, newFragment)
                            .commit()
                }
                2 -> {
                    newFragment.setImageIds(AndroidImageAssets.legs)
                    newFragment.setImageIndex(listIndex)
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.legs_fragment_container, newFragment)
                            .commit()
                }
                else -> {
                }
            }
        } else {
            when (bodyPartNumber) {
                0 -> headIndex = listIndex
                1 -> bodyIndex = listIndex
                2 -> legIndex = listIndex
                else -> {
                }
            }
        }
    }

    private fun startBuildAndroidActivity() {
        val b = Bundle()
        b.putInt(HEAD_INDEX_KEY, headIndex)
        b.putInt(BODY_INDEX_KEY, bodyIndex)
        b.putInt(LEGS_INDEX_KEY, legIndex)
        val intent = Intent(this, BuildAndroidActivity::class.java)
        intent.putExtras(b)
        startActivity(intent)
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        outState?.putInt(HEAD_INDEX_KEY, headIndex)
        outState?.putInt(BODY_INDEX_KEY, bodyIndex)
        outState?.putInt(LEGS_INDEX_KEY, legIndex)
    }
}