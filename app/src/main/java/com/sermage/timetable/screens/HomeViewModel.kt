package com.sermage.timetable.screens

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sermage.timetable.data.generator.DataGenerator
import com.sermage.timetable.data.pojo.Lesson

class HomeViewModel(application: Application): AndroidViewModel(application) {

    private val data=DataGenerator.getLessons()
    private val lessons=MutableLiveData<List<Lesson>>()

    fun getLessons():LiveData<List<Lesson>>{
        return lessons
    }
    init{
        getData()
    }

    private fun getData(){
        lessons.value=data
    }

}