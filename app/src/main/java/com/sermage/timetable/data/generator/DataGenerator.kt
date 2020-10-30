package com.sermage.timetable.data.generator

import com.sermage.timetable.R
import com.sermage.timetable.data.pojo.*

object DataGenerator {


    private val literature =
        ObligatoryLesson(
            "Literature",
            "Joey Tribbiani",
            R.drawable.book_shelf_48,
            "9:00",
            "9:45"
        )
    private val math =
        ObligatoryLesson("Mathematics", "Chandler Bing", R.drawable.math_icon, "8:00", "8:45",true)
    private val history =
        ObligatoryLesson("History", "Ross Geller", R.drawable.archery, "10:00", "10:45",true)
    private val physics =
        ObligatoryLesson("Physics", "Sheldon", R.drawable.physics_icon, "12:00", "12:45")
    private val chemistry =
        ObligatoryLesson("Chemistry", "Walter White", R.drawable.chemistry_icon, "13:00", "13:45")
    private val compScience =
        ObligatoryLesson(
            "Computer Science",
            "Thomas Andersen",
            R.drawable.computer_icon,
            "16:45",
            "17:30",
            true
        )

    private val actingClass = AdditionalLesson(
        "Acting class",
        "Joey Tribbiani",
        R.drawable.acting_icon,
        "11:00",
        "12:00",
        "Seminar from the famous actor \"What is it to be an actor\"."
    )
    private val physicalEducation = AdditionalLesson(
        "Physical Education",
        "Boris Blade",
        R.drawable.icon_basketball_48,
        "15:00",
        "16:30",
        "Interactive presentation for the Junior World Championship in Los Angeles."
    )

    private val homework1 = Homework(
        "Literature",
        R.drawable.book_shelf_48,
        "Read chapters 1-3 of The Three-Body Problem and prepare for discussion.",
        "2021-03-20"
    )
    private val homework2 = Homework(
        "Physics",
        R.drawable.physics_icon,
        "Read about The Big Bang Theory and prepare the presentation.",
        "2021-03-21"
    )
    private val homework3 = Homework(
        "Computer science",
        R.drawable.computer_icon,
        "Read The Clean Code (Robert C.Martin) and learn solid principles.",
        "2021-03-20"
    )

    private val listOfExams = mutableListOf(Exams("2021-06-06"))

    private val listOfLessons = mutableListOf(
        literature, math, history, physics, chemistry,
        compScience
    )

    private val listOfAllLessons = mutableListOf(
        literature, math, history, physics, chemistry,
        compScience, physicalEducation, actingClass
    )


    private val listOfHomework = mutableListOf(homework1, homework2, homework3)

    fun getExams(): List<Exams> {
        return listOfExams
    }

    fun getLessons(): List<ObligatoryLesson> {
        return listOfLessons
    }

    fun getAllLessons(): MutableList<Lesson> {
        return listOfAllLessons
    }


    fun getHomework(): List<Homework> {
        return listOfHomework
    }

}