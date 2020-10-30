package com.sermage.timetable.screens.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sermage.timetable.converters.convertStringToTime
import com.sermage.timetable.data.generator.DataGenerator
import com.sermage.timetable.data.pojo.Exams
import com.sermage.timetable.data.pojo.Homework
import com.sermage.timetable.data.pojo.ObligatoryLesson

class HomeViewModel : ViewModel() {

    private val lessons = MutableLiveData<List<ObligatoryLesson>>()
    private val homework = MutableLiveData<List<Homework>>()
    private val exams = MutableLiveData<List<Exams>>()

    fun getLessons(): LiveData<List<ObligatoryLesson>> {
        return lessons
    }

    fun getHomework(): LiveData<List<Homework>> {
        return homework
    }

    fun getExams(): LiveData<List<Exams>> {
        return exams
    }

    init {
        getData()
    }

    private fun getData() {
        val lessonsData = DataGenerator.getLessons()
        val homeworkData = DataGenerator.getHomework()
        val examsData = DataGenerator.getExams()
        val sortedLessons = lessonsData.sortedBy { convertStringToTime(it.startTime).hourOfDay }
        lessons.value = sortedLessons
        homework.value = homeworkData
        exams.value = examsData
    }

}