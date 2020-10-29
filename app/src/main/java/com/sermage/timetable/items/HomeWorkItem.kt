package com.sermage.timetable.items

import android.graphics.Color
import com.sermage.timetable.R
import com.sermage.timetable.R.color
import com.sermage.timetable.data.pojo.Homework
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.homework_item.*
import kotlinx.android.synthetic.main.homework_item.view.*
import org.joda.time.Days
import org.joda.time.LocalDate

class HomeWorkItem(private val homework: Homework):Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.apply {
            textViewHomeWorkTitle.text=homework.name
            textViewDescriptionOfHomeWork.text=homework.description
            imageViewHomeworkIcon.setImageResource(homework.image)
            viewDaysLeft.textViewNumberOfDays.text="${daysLeft(homework.finishDate)} days left "
            if(daysLeft(homework.finishDate)<3){
                viewDaysLeft.imageViewClockIcon.setColorFilter(Color.parseColor("#FF0000"))
                viewDaysLeft.textViewNumberOfDays.setTextColor(Color.parseColor("#FF0000"))
            }else{
                viewDaysLeft.imageViewClockIcon.setColorFilter(color.light_grey)
                viewDaysLeft.textViewNumberOfDays.setTextColor(Color.parseColor("#5A5A5A"))
            }
        }
    }

    override fun getLayout(): Int = R.layout.homework_item

    private fun daysLeft(date:String):Int{
            val toDate=LocalDate(date)
        return Days.daysBetween(LocalDate.now(),toDate).days

    }
}