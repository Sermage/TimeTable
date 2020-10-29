package com.sermage.timetable

import org.joda.time.LocalTime
import org.joda.time.format.DateTimeFormat

fun converterStringToTime(timeAsString:String):LocalTime{
    val formatter=DateTimeFormat.forPattern("HH:mm")
    return formatter.parseLocalTime(timeAsString)
}