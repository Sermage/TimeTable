package com.sermage.timetable.items

import com.sermage.timetable.R
import com.sermage.timetable.data.pojo.Homework
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.homework_item.*

class HomeWorkItem(private val homework: Homework):Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.apply {
            textViewHomeWorkTitle.text=homework.name
            textViewDescriptionOfHomeWork.text=homework.description
            imageViewHomeworkIcon.setImageResource(homework.image)
//            viewDaysLeft.textViewNumberOfDays.text=homework.finishDate.minusDays(LocalTime.now().millisOfSecond).toString()
        }
    }

    override fun getLayout(): Int = R.layout.homework_item
}