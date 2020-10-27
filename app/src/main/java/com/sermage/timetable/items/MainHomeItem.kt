package com.sermage.timetable.items

import com.sermage.timetable.R
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.main_home_item.*

class MainHomeItem(private val items:List<Item>):Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.recyclerViewItems.adapter=GroupAdapter<GroupieViewHolder>().apply {
            addAll(items)
        }
    }
    override fun getLayout(): Int = R.layout.main_home_item
}