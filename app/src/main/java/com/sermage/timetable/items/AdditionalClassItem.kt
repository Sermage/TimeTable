package com.sermage.timetable.items

import com.sermage.timetable.R
import com.sermage.timetable.data.pojo.AdditionalLesson
import com.sermage.timetable.data.pojo.ObligatoryLesson
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.additional_class_item.*

class AdditionalClassItem(private val lesson: AdditionalLesson):Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.apply {
            textViewAddClassName.text=lesson.name
            textViewTeacherName.text="Mr. "+lesson.teacher.substringAfter(" ")
            textViewAddClassDescription.text=lesson.description
            imageViewAddClassIcon.setImageResource(lesson.image)
            textViewStartTime.text=lesson.startTime
            textViewEndTime.text=lesson.endTime
            itemView.isClickable=false
        }
    }

    override fun getLayout(): Int = R.layout.additional_class_item
}