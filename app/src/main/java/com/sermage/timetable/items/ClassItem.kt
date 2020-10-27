package com.sermage.timetable.items

import com.sermage.timetable.R
import com.sermage.timetable.data.pojo.Lesson
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.class_item1.*

class ClassItem(private val lesson: Lesson): Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.apply {
            textViewClassName.text=lesson.name
            imageViewClassIcon.setImageResource(lesson.image)
//            textViewLessonStartTime.text=subject.startTime.toString()
//            textViewLessonEndTime.text=subject.endTime.toString()
        }
    }

    override fun getLayout(): Int = R.layout.class_item1
}