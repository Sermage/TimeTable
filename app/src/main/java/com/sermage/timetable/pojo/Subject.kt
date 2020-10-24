package com.sermage.timetable.pojo

import java.sql.Time

data class Subject (
    val name:String,
    val teacher:String,
    val image:Int,
    val time:Time
)
