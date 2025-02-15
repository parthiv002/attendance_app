package com.example.attendance_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SubjectAdapter(private val subjects:MutableList<Subject>) :RecyclerView.Adapter<SubjectAdapter.ViewHolder>()
{
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val tvSubjectName=itemView.findViewById<TextView>(R.id.tvSubjectName)
        val tvAttendClass=itemView.findViewById<TextView>(R.id.tvAtClasses)
        val tvTotalClass=itemView.findViewById<TextView>(R.id.tvTotalClass)
        val tvPercentage=itemView.findViewById<TextView>(R.id.tvPercentage)
        val btnYes=itemView.findViewById<Button>(R.id.btnYes)
        val btnNo=itemView.findViewById<Button>(R.id.btnNo)
        val btnEdit=itemView.findViewById<Button>(R.id.btnEdit)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectAdapter.ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.each_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubjectAdapter.ViewHolder, position: Int) {
        val subject=subjects[position]
        holder.tvSubjectName.text=subject.name
        updatePercentage(subject.attendClass,subject.totalClass,holder.tvAttendClass,holder.tvTotalClass,holder.tvPercentage)
    }

    private fun updatePercentage(attendClass: Int, totalClass: Int, tvAttendClass: TextView?, tvTotalClass: TextView?, tvPercentage: TextView?) {
        val percentage=if(totalClass>0){
            ((attendClass*1f)/totalClass) * 100f
        }
        else{
            0f
        }
        tvAttendClass?.text="$attendClass"
        tvTotalClass?.text="$totalClass"
        tvPercentage?.text="$percentage"
    }

    override fun getItemCount(): Int {
        return subjects.size
    }

}