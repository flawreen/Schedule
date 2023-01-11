package com.example.scheduleAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.data.ScheduleData
import com.example.schedule.R

class ScheduleAdapter (
    private val context: Context?
        ) : RecyclerView.Adapter<ScheduleAdapter.ViewHolder>() {

    private val scheduleData = ScheduleData.materii

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val materie: TextView = view.findViewById(R.id.tv_materie)
        val ora: TextView = view.findViewById(R.id.tv_hour)
        val sala: TextView = view.findViewById(R.id.tv_sala)
        val ziua: TextView = view.findViewById(R.id.tv_ziua)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val scheduleView = LayoutInflater.from(parent.context)
            .inflate(R.layout.schedule, parent, false)
        return ViewHolder(scheduleView)
    }

    override fun getItemCount(): Int {
        return scheduleData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = scheduleData[position]
        holder.materie.text = context?.resources?.getString(R.string.blueprint, item.materie)
        holder.ora.text = context?.resources?.getString(R.string.blueprint, item.ora)
        // holder.sala.text = context?.resources?.getString(R.string.blueprint, item.sala)
        holder.sala.text = when(item.sala) {
            "Pompeiu" -> context?.resources?.getString(R.string.blueprint, item.sala)
            "Limbi Straine" -> context?.resources?.getString(R.string.blueprint, item.sala)
            else -> context?.resources?.getString(R.string.sala, item.sala)
        }
        holder.ziua.text = context?.resources?.getString(R.string.blueprint, item.ziua)
    }


}