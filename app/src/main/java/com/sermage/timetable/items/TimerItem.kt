package com.sermage.timetable.items

import android.os.CountDownTimer
import com.sermage.timetable.R
import com.sermage.timetable.data.pojo.Exams
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.timer_item.*
import org.joda.time.LocalDate

class TimerItem(
    private val exams: Exams
) : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        val futureDate = LocalDate(exams.startDate)

        object : CountDownTimer(futureDate.toDate().time - System.currentTimeMillis(), 1000) {

            override fun onTick(millisUntilFinished: Long) {
                val min = (millisUntilFinished / (1000 * 60)) % 60
                val hours = (millisUntilFinished / (1000 * 60 * 60)) % 24
                val days = ((millisUntilFinished / (1000 * 60 * 60)) / 24).toInt()
                with(viewHolder) {
                    textViewDays.text = String.format("%02d", days)
                    textViewHours.text = String.format("%02d", hours)
                    textViewMinutes.text = String.format("%02d", min)
                }
            }

            override fun onFinish() {
                viewHolder.textViewTimerTitle.text = "Time is up!Hope you have prepared!"
            }
        }.start()

    }

    override fun getLayout(): Int = R.layout.timer_item
}