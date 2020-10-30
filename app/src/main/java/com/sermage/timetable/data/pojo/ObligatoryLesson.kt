package com.sermage.timetable.data.pojo


data class ObligatoryLesson(

    override val name: String,
    override val teacher: String,
    override val image: Int,
    override val startTime: String,
    override val endTime: String,
    val isRemote: Boolean = false,
) : Lesson()
