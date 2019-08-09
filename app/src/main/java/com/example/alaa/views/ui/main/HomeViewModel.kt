package com.example.alaa.views.ui.main

import android.view.MenuItem
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.alaa.R
import com.example.alaa.views.ViewPager.ImageSlider
import java.util.*


class HomeViewModel : ViewModel() {


    /**
     * 0 : Home
     * 1 : Shop
     * 2 : Forum
     */
    var bottomNavSelectedPage = MutableLiveData(0)


    fun onBottomNavItemSelected(page: Int) {
        bottomNavSelectedPage.run { setValue(page) }
    }


    fun onNavigationItemSelected(item: MenuItem): Boolean {
//        when (item.getItemId()) {
//            R.id.navigation_dashboard -> {
//                Log.d("test", "test1")
//                return true
//            }
//            R.id.navigation_notifications -> {
//                Log.d("test", "test2")
//                return true
//            }
//        }
       return false
    }


    /**  get image list of view pager */
    fun getImageList(): List<ImageSlider> {
        val imageList = ArrayList<ImageSlider>()
        imageList.add(ImageSlider("ad_00", R.drawable.ad_0))
        imageList.add(ImageSlider("ad_01", R.drawable.ad_01))
        imageList.add(ImageSlider("ad_02", R.drawable.ad__02))
        return imageList
    }
}