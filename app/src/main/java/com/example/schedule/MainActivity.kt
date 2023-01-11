package com.example.schedule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.schedule.databinding.ActivityMainBinding
import com.example.scheduleAdapter.ScheduleAdapter
import java.time.LocalDate
import java.time.temporal.ChronoUnit

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.scheduleView.adapter = ScheduleAdapter(this)
        binding.scheduleView.setHasFixedSize(true)

        val collegeYearStart = LocalDate.parse("2022-10-03")
        var currentDate = LocalDate.now()
        var nrSaptamana = (ChronoUnit.DAYS.between(collegeYearStart, currentDate) / 7 + 1).toString()
        binding.tvSaptamana.text = getString(R.string.saptamana, nrSaptamana)
    }

}