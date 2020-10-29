package com.sermage.timetable.screens.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sermage.timetable.converterStringToTime
import com.sermage.timetable.data.generator.DataGenerator
import com.sermage.timetable.data.pojo.Homework
import com.sermage.timetable.data.pojo.ObligatoryLesson

class HomeViewModel:ViewModel() {

    private val lessons=MutableLiveData<List<ObligatoryLesson>>()
    private val homework=MutableLiveData<List<Homework>>()

    fun getLessons():LiveData<List<ObligatoryLesson>>{
        return lessons
    }
    fun getHomework():LiveData<List<Homework>>{
        return homework
    }
    init{
        getData()
    }

    private fun getData(){
        val data1=DataGenerator.getLessons()
        val data2=DataGenerator.getHomework()
        val sortedData1=data1.sortedBy { converterStringToTime(it.startTime).hourOfDay }
        lessons.value=sortedData1
        homework.value=data2
    }

}