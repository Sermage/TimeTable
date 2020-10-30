package com.sermage.timetable.converters

import org.joda.time.Days
import org.joda.time.LocalDate
import org.joda.time.LocalTime
import org.joda.time.format.DateTimeFormat

fun convertStringToTime(timeAsString:String):LocalTime{
    val formatter=DateTimeFormat.forPattern("HH:mm")
    return formatter.parseLocalTime(timeAsString)
}

fun daysLeft(date:String):Int{
    val toDate= LocalDate(date)
    val result=Days.daysBetween(LocalDate.now(),toDate).days
    return if(result>0) result else 0

}