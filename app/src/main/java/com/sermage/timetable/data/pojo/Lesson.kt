package com.sermage.timetable.data.pojo

import com.sermage.timetable.converterStringToTime

abstract class Lesson:Comparable<Lesson> {
    abstract val name: String
    abstract val teacher: String
    abstract val image: Int
    abstract val startTime: String
    abstract val endTime: String

    override fun compareTo(other: Lesson): Int {
        return converterStringToTime(startTime).secondOfMinute.compareTo(converterStringToTime(other.startTime).secondOfMinute)
    }
}