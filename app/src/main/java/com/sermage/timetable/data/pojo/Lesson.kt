package com.sermage.timetable.data.pojo

abstract class Lesson {
    abstract val name: String
    abstract val teacher: String
    abstract val image: Int
    abstract val startTime: String
    abstract val endTime: String
}