package com.fajar.myflexiblefragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmenManager = supportFragmentManager
        val homeFragment = HomeFragment()
        val fragment = fragmenManager.findFragmentByTag(HomeFragment::class.java.simpleName)

        if (fragment !is HomeFragment) {
            Log.d("MyFlexibleFragment", "Fragment Name :" + HomeFragment::class.java.simpleName)

            // Fragment KTX
            fragmenManager.commit{
                add(R.id.frame_container, homeFragment, HomeFragment::class.java.simpleName)
            }
//            fragmenManager.beginTransaction()
//                .add(R.id.frame_container, homeFragment, HomeFragment::class.java.simpleName)
//                .commit()
        }
    }
}