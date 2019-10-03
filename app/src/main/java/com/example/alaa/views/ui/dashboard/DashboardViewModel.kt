package com.example.alaa.views.ui.dashboard

import androidx.lifecycle.ViewModel

/*
 *  this view model is for Dashboard bottom sheet
 *  it determined that type of bottom sheet
 *  and thus when bottom sheet shows it look in type
 *  and change its title and icon for bottom sheet
 */

class DashboardViewModel : ViewModel() {

    var type = BottomSheetType.Collection

    fun onTypeSelected(type: BottomSheetType) {
        this.type = type
    }

}

enum class BottomSheetType {
    MyVideos,
    MyBooklets,
    Collection
}