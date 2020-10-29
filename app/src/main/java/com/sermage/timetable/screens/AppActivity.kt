package com.sermage.timetable.screens

import android.os.Bundle
import android.view.View
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.sermage.timetable.R
import com.sermage.timetable.adapters.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.tab_item.view.*
import net.danlew.android.joda.JodaTimeAndroid

class AppActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        JodaTimeAndroid.init(this)
        val tabLayout: TabLayout = tabLayout
        val viewPager: ViewPager2 = viewPager
        viewPager.isUserInputEnabled=false
        viewPager.adapter = FragmentPagerAdapter(this)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.setCustomView(R.layout.tab_item)
                    tab.customView?.tab_title?.text = getString(R.string.home_title)
                    tab.customView?.tab_icon?.setImageResource(R.drawable.outline_home_white_36dp)
                    tab.customView?.tab_icon?.setColorFilter(resources.getColor(R.color.light_green))
                }
                1 -> {
                    tab.setCustomView(R.layout.tab_item)
                    tab.customView?.tab_title?.text = getString(R.string.classes_title)
                    tab.customView?.tab_icon?.setImageResource(R.drawable.outline_calendar_today_white_24dp)
                    tab.customView?.tab_title?.visibility = View.GONE
                }
                2 -> {
                    tab.setCustomView(R.layout.tab_item)
                    tab.customView?.tab_icon?.setImageResource(R.drawable.baseline_list_alt_white_36dp)

                }
                3 -> {
                    tab.setCustomView(R.layout.tab_item)
                    tab.customView?.tab_icon?.setImageResource(R.drawable.baseline_star_border_white_36dp)

                }
            }

        }.attach()
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.customView?.tab_title.apply {
                    this?.visibility = View.VISIBLE
                }
                tab?.customView?.tab_icon?.setColorFilter(resources.getColor(R.color.light_green))
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.customView?.tab_title.apply {
                    this?.visibility = View.GONE
                }
                tab?.customView?.tab_icon?.setColorFilter(resources.getColor(R.color.white))
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
    }
}