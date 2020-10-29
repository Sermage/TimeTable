package com.sermage.timetable.items

import com.sermage.timetable.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.header_item.*

class HeaderItem(private val title:String="",private val numberOfItems:String="") : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.apply {
            textViewHeaderTitle.text=title
            textViewNumberOfItems.text=numberOfItems
        }
    }

    override fun getLayout(): Int = R.layout.header_item

}