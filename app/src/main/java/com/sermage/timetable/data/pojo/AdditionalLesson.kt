package com.sermage.timetable.data.pojo

data class AdditionalLesson(
    override val name: String,
    override val teacher: String,
    override val image: Int,
    override val startTime: String,
    override val endTime: String,
    val description: String
) : Lesson()