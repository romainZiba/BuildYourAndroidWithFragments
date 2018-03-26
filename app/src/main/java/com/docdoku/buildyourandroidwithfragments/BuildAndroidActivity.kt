package com.docdoku.buildyourandroidwithfragments

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.docdoku.buildyourandroidwithfragments.data.AndroidImageAssets

class BuildAndroidActivity : AppCompatActivity() {

    /**
     *  Part 1: Display three Fragments in a single Activity
     *  TODO (1) Create a layout file that displays one body part image named fragment_body_part.xml
     *  This layout should contain a single ImageView
     *  TODO (2) Create a new class called BodyPartFragment which extends from Fragment to display
     *  an image of an Android body part. You'd pass the list of body parts to each fragment
     *  fragment.setImageIds(AndroidImageAssets.getBodies()) for example
     *  TODO (3) In the layout activity_build_android.xml, create containers to hold the head, body and feet of the custom Android
     *  One container should be 180dp in height. This container will contain dynamic fragment
     *  TODO (4) Instantiate three fragments for Head, Body and Legs.
     *  In these fragments, you'd show the first image in the list of head/body/legs images
     *
     *  Part 2:
     *  TODO (5): While clicking on an item, change the image to display by the next one
     *  TODO (6): Save the state of the fragment to display the same images in each fragment while rotating the device
     *
     *  Part 2: Display a fragment in a new activity of all the images in a grid
     *  TODO (1) Create a fragment_master_list.xml layout file to display all our images
     *  This should be a RecyclerView displaying items in a grid
     *  TODO (2) Create a new class called MasterListFragment which will display the RecyclerView list of ALL Android images
     *  TODO (3) In the MasterListFragment class, instantiate a new MasterListAdapter and set it on the RecyclerView
     *  TODO (4) Implement the MasterListAdapter functions
     *  TODO (5) Create a new Activity named MainActivity and a corresponding layout file that displays a MasterListFragment
     *  Remember, to display a static fragment in a layout file, use the <fragment> tag
     *  TODO (6) Declare a MainActivity in the manifest and set it to launch upon opening this app
     *
     *  Part3: Communication between fragment and activity     *
     *  In MasterListFragment
     *  TODO (1) Define a new interface OnImageClickListener that triggers a callback in the host activity
     *  TODO (2) While clicking on an item, invoke the callback
     *
     *  In MainActivity
     *  TODO (3) Implement the fragment callback, by displaying a toast to begin with
     *  TODO (4) Then, store information about where the user clicked.
     *  Add a button to the layout in order to send an intent containing the selected body parts in a Bundle
     *  Start this activity with the bundle defined
     *
     *  Next we want to either display the static and dynamic fragments in the same layout if the screen width is > 600dp
     *  Otherwise, we stick with the previous solution, i.e starting a new activity
     *  TODO (5) Create a new two-pane activity_main layout for tablets (sw800dp)
     *  TODO (6) Build the layout to display the MasterListFragment and all BodyPartFragments
     *  TODO (7) In MainActivity, handle the two different cases
     *  Either the fragments are all displayed on a screen > 600dp or the previous behavior is kept
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_build_android)

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
    }
}
