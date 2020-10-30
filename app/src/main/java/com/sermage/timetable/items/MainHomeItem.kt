package com.sermage.timetable.items

import com.sermage.timetable.R
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.main_home_item.*

class MainHomeItem(private val items: List<Item>) : Item() {

    var itemListener: OnItemListener? = null

    interface OnItemListener {
        fun onItemClick(item: Item)
    }

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        val groupAdapter=GroupAdapter<GroupieViewHolder>()
        viewHolder.recyclerViewItems.adapter = groupAdapter.apply {
            addAll(items)
            setOnItemClickListener { item, view ->
                itemListener?.onItemClick(item as Item)
            }
        }

    }

    override fun getLayout(): Int = R.layout.main_home_item
}