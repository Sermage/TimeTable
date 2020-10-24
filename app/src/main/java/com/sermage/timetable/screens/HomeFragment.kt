package com.sermage.timetable.screens

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sermage.timetable.R
import kotlinx.android.synthetic.main.fragment_home.view.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class HomeFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tvDays=view.tvDays
        val tvHours=view.tvHours
        val tvMinutes=view.tvMinutes
        val tvTimerTitle=view.tvTimerTitle

        var futureMinDate = Date()
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
        try {
            futureMinDate = sdf.parse("2021-01-12")
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        // Here futureMinDate.time Returns the number of milliseconds since January 1, 1970, 00:00:00 GM
        // So we need to subtract the millis from current millis to get actual millis
        object : CountDownTimer(futureMinDate.time - System.currentTimeMillis(), 1000) {

            override fun onTick(millisUntilFinished: Long) {
                val minutes = (millisUntilFinished / (1000 * 60)) % 60
                val hours = (millisUntilFinished / (1000 * 60 * 60)) % 24
                val days = ((millisUntilFinished / (1000 * 60 * 60)) / 24).toInt()
                tvDays.text=String.format("%02d",days)
                tvHours.text=String.format("%02d",hours)
                tvMinutes.text=String.format("%02d",minutes)
            }

            override fun onFinish() {
                tvTimerTitle.text=getString(R.string.countdown_finish_title)
            }
        }.start()
    }
}