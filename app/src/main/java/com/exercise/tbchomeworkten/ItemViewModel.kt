package com.exercise.tbchomeworkten

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ItemViewModel:ViewModel() {
    private val choices = MutableLiveData<List<Info>>()
    val _choices: MutableLiveData<List<Info>> get() = choices

    init {
        choices.value = getOutputs()
    }

    private fun getOutputs(): List<Info> {
        val allItems = mutableListOf<Info>()

        val one = Info(0,R.drawable.iv_profile, "Edit Profile","",R.drawable.ic_arrow,false, ItemType.ARROW)
        val two = Info(1,R.drawable.iv_location, "Address", "",R.drawable.ic_arrow, false, ItemType.ARROW)
        val three = Info(2,R.drawable.iv_notification, "Notification", "",R.drawable.ic_arrow, false, ItemType.ARROW)
        val four = Info(3,R.drawable.iv_wallet, "Payment", "",R.drawable.ic_arrow, false, ItemType.ARROW)
        val five = Info(4,R.drawable.iv_security, "Security", "",R.drawable.ic_arrow, false, ItemType.ARROW)
        val six = Info(5,R.drawable.iv_language, "Language", "English (US)",R.drawable.ic_arrow, false, ItemType.ARROW)
        val seven = Info(6,R.drawable.iv_eye, "Dark Mode", "",0 , true, ItemType.CHECKBOX)
        val eight = Info(7,R.drawable.iv_locker, "Privacy Policy", "",R.drawable.ic_arrow,false, ItemType.ARROW)
        val nine = Info(8,R.drawable.iv_info, "Help Center", "",R.drawable.ic_arrow, false, ItemType.ARROW)
        val ten = Info(9,R.drawable.iv_friends, "Invite Friends", "",R.drawable.ic_arrow, false, ItemType.ARROW)
        val eleven = Info(10,R.drawable.iv_logout, "Logout", "",0, false, ItemType.DEFAULT)

        allItems.add(one)
        allItems.add(two)
        allItems.add(three)
        allItems.add(four)
        allItems.add(five)
        allItems.add(six)
        allItems.add(seven)
        allItems.add(eight)
        allItems.add(nine)
        allItems.add(ten)
        allItems.add(eleven)
        return allItems
    }

}