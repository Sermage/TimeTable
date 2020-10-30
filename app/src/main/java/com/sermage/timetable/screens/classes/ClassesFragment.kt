package com.sermage.timetable.screens.classes

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sermage.timetable.R
import com.sermage.timetable.data.pojo.AdditionalLesson
import com.sermage.timetable.data.pojo.ObligatoryLesson
import com.sermage.timetable.items.AdditionalClassItem
import com.sermage.timetable.items.ClassItem2
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.fragment_classes.view.*


class ClassesFragment : Fragment() {

    private lateinit var groupAdapter: GroupAdapter<GroupieViewHolder>
    private val classesViewModel: ClassesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        groupAdapter = GroupAdapter()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_second, menu)
        super.onCreateOptionsMenu(menu, inflater)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_classes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        view.recyclerViewClasses.adapter = groupAdapter
        classesViewModel.getLessons().observe(viewLifecycleOwner, {
            val classItems = mutableListOf<Item>()
            for (lesson in it) {
                when (lesson) {
                    is ObligatoryLesson -> classItems.add(ClassItem2(lesson))
                    is AdditionalLesson -> classItems.add(AdditionalClassItem(lesson))
                }
            }
            groupAdapter.addAll(classItems)
            groupAdapter.setOnItemClickListener { item, view ->
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
        })
    }

}