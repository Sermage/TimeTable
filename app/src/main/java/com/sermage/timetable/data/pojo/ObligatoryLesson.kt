package com.sermage.timetable.data.pojo

import com.sermage.timetable.R


    data class ObligatoryLesson (

    override val name:String,
    override val teacher: String="",
    override val image: Int,
    override val startTime: String,
    override val endTime: String,
    val isRemote:Boolean=false,
): Lesson()
