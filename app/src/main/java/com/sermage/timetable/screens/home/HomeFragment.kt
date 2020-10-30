package com.sermage.timetable.screens.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sermage.timetable.R
import com.sermage.timetable.items.*
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment() {


    private lateinit var groupAdapter: GroupAdapter<GroupieViewHolder>
    private val viewModel: HomeViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        groupAdapter = GroupAdapter()

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_main, menu)
        super.onCreateOptionsMenu(menu, inflater)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        val recyclerViewHome = view.recyclerViewHome
        recyclerViewHome.adapter = groupAdapter
        viewModel.getExams().observe(viewLifecycleOwner, {
            //the first section with timer
            Section().apply {
                add(TimerItem(it[0]))
                groupAdapter.add(this)
            }
        })
        //getting data for the second section
        viewModel.getLessons().observe(viewLifecycleOwner, {
            val listItems = mutableListOf<ClassItem>()
            for (lesson in it) {
                listItems.add(ClassItem(lesson))
            }
            val classes = MainHomeItem(listItems)
            classes.itemListener = object : MainHomeItem.OnItemListener {
                override fun onItemClick(item: Item) {
                    var intent =
                        activity?.packageManager?.getLaunchIntentForPackage("com.skype.raider")
                    if (intent != null) {
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)
                    } else {
                        intent = Intent(Intent.ACTION_VIEW)
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        intent.data = Uri.parse("market://details?id=com.skype.raider")
                        startActivity(intent)
                    }

                }
            }
            //the second section with classes
            Section().apply {
                setHeader(HeaderItem(getString(R.string.classes_title), "${it.size} classes today"))
                add(classes)
                groupAdapter.add(this)
            }
        })
        //getting data for the third section
        viewModel.getHomework().observe(viewLifecycleOwner, {
            val listItems = mutableListOf<Item>()
            for (homework in it) {
                listItems.add(HomeWorkItem(homework))
            }
            val homework = MainHomeItem(listItems)
            //the third section with homework
            Section().apply {
                setHeader(HeaderItem(getString(R.string.homework_title)))
                add(homework)
                groupAdapter.add(this)
            }
        })
    }

}