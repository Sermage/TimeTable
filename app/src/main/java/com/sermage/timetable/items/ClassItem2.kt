package com.sermage.timetable.items

import android.view.View
import com.sermage.timetable.R
import com.sermage.timetable.data.pojo.ObligatoryLesson
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.class_item2.*

class ClassItem2(private val lesson: ObligatoryLesson) : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.apply {
            textViewClassName.text = lesson.name
            imageViewClassIcon.setImageResource(lesson.image)
            textViewClassTeacherName.text = "Mr." + lesson.teacher.substringAfter(" ")
            textViewStartTime.text = lesson.startTime
            textViewEndTime.text = lesson.endTime
            if (lesson.isRemote) {
                viewIsRemote.visibility = View.VISIBLE
                itemView.isClickable = true
            } else {
                viewIsRemote.visibility = View.GONE
                itemView.isClickable = false
            }

        }
    }

    override fun getLayout(): Int = R.layout.class_item2
}