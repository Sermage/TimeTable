package com.sermage.timetable.data.generator

import com.sermage.timetable.R
import com.sermage.timetable.data.pojo.Lesson

object DataGenerator {


   private val literature= Lesson("Literature","Joey Tribiani", R.drawable.book_shelf_48,"8:00","8:45")
   private val math= Lesson("Math","Chandler Bing", R.drawable.math_icon,"9:00","9:45")
   private val history= Lesson("History","Ross Geller", R.drawable.archery,"10:00","10:45")
   private val physics= Lesson("Physics","Sheldon", R.drawable.physics_icon,"10.15","10:45")
   private val chemistry= Lesson("Chemistry","Walter White", R.drawable.chemistry_icon,"11:00","11:45")
   private val compScience= Lesson("Computer Science","Thomas Andersen", R.drawable.computer_icon,"12.00","12:45")

   private val listOfLessons= mutableListOf<Lesson>().apply {
        add(literature)
        add(math)
        add(history)
        add(physics)
        add(chemistry)
        add(compScience)
    }

    fun getLessons():List<Lesson>{
        return listOfLessons
    }

}