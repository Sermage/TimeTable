package com.sermage.timetable.items

import android.view.View
import com.sermage.timetable.R
import com.sermage.timetable.converterStringToTime
import com.sermage.timetable.data.pojo.ObligatoryLesson
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.class_item1.*
import org.joda.time.LocalTime


class ClassItem(val lesson: ObligatoryLesson): Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.apply {
            textViewClassName.text=lesson.name
            imageViewClassIcon.setImageResource(lesson.image)
            textViewLessonStartTime.text=lesson.startTime
            textViewLessonEndTime.text=lesson.endTime
            if(lesson.isRemote){
                viewIsRemote.visibility= View.VISIBLE
                itemView.isClickable=true
            }else{
                viewIsRemote.visibility=View.GONE
                itemView.isClickable=false
            }

        }
        val startTime=converterStringToTime(lesson.startTime)
        val endTime= converterStringToTime(lesson.endTime)
        val time= LocalTime.now()
        if(time>=startTime && time<=endTime){

        }
    }

    override fun getLayout(): Int = R.layout.class_item1
}