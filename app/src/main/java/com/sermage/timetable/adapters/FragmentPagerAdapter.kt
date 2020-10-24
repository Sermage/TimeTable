package com.sermage.timetable.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sermage.timetable.screens.ClassesFragment
import com.sermage.timetable.screens.DummyFragment
import com.sermage.timetable.screens.HomeFragment

class FragmentPagerAdapter(fragment: FragmentActivity):FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int=4

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0-> HomeFragment()
            1-> ClassesFragment()
            2-> DummyFragment()
            3-> DummyFragment()
            else->throw IllegalArgumentException()
        }
    }
}