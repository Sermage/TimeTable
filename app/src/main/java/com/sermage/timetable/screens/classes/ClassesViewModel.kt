package com.sermage.timetable.screens.classes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sermage.timetable.converterStringToTime
import com.sermage.timetable.data.generator.DataGenerator
import com.sermage.timetable.data.pojo.Lesson
import com.sermage.timetable.data.pojo.ObligatoryLesson

class ClassesViewModel:ViewModel() {

    private val lessons=MutableLiveData<List<Lesson>>()

    init {
        getData()
    }
    fun getLessons():LiveData<List<Lesson>>{
        return lessons
    }

    private fun getData(){
        val data=DataGenerator.getAllLessons()
        val sortedData=data.sortedBy { converterStringToTime(it.startTime).hourOfDay }
        lessons.value=sortedData
    }

}