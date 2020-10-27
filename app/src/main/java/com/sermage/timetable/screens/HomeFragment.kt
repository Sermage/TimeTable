package com.sermage.timetable.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sermage.timetable.R
import com.sermage.timetable.items.*
import com.sermage.timetable.data.pojo.Exams
import com.sermage.timetable.data.pojo.Homework
import com.sermage.timetable.data.pojo.Lesson
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Section
import kotlinx.android.synthetic.main.fragment_home.view.*
import androidx.fragment.app.viewModels
import com.xwray.groupie.kotlinandroidextensions.Item


class HomeFragment : Fragment() {

    private lateinit var recyclerViewMain:RecyclerView
    private lateinit var groupAdapter:GroupAdapter<GroupieViewHolder>
    private val viewModel:HomeViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        groupAdapter= GroupAdapter()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.recyclerViewHome.adapter=groupAdapter
        Section().apply {
            add(TimerItem(Exams(("2021-01-12"))))
            groupAdapter.add(this)
        }

        Section().apply {
            setHeader(HeaderItem("Homework"))
            add(MainHomeItem(getHomework()))
            groupAdapter.add(this)
        }

        viewModel.getLessons().observe(viewLifecycleOwner,{
            val listItems= mutableListOf<Item>()
            for(lesson in it){
                listItems.add(ClassItem(lesson))
            }
            val classes=MainHomeItem(listItems)
            Section().apply {
                setHeader(HeaderItem("Classes","${it.size} classes today"))
                add(classes)
                groupAdapter.add(this)
            }
        })
    }

    fun getHomework():List<HomeWorkItem>{
        val homework1=Homework("Literature",R.drawable.book_shelf_48,"Read scenes 1.1-1.2 of\n the Master and Margarita.")
        val homework2=Homework("Math",R.drawable.math_icon,"Complete tasks on pages 43-44\n in textbook also you should make graphics")
        return mutableListOf(HomeWorkItem(homework1), HomeWorkItem(homework2))
    }

}