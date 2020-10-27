package com.sermage.timetable.data.pojo

import com.sermage.timetable.R


data class Lesson (
    val name:String,
    val teacher:String="",
    val image:Int,
    val startTime:String="",
    val endTime:String=""
)
