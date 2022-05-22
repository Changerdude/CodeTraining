package com.example.myfirstroom

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView


class StudentAdapter( private val studentList: List<Students>): RecyclerView.Adapter<ViewHolder>() {
   private var mStudentList: MutableList<Students> = studentList as MutableList<Students>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //inflate
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_list_layout, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //add element to view holder
        val itemVM = mStudentList[position]
        holder.fName.text = itemVM.firstName
        holder.lName.text = itemVM.lastName
        //click listener
        holder.cards.setOnClickListener{
            val intent = Intent(holder.cards.context, DetailedView::class.java)
            intent.putExtra("student", itemVM)

            holder.cards.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        //size of the list/data source
        return mStudentList.size
    }

    fun deleteItem(i : Int, repo : StudentRepository){
        repo.deleteStudent(mStudentList[i])
        mStudentList.remove(mStudentList[i])
        notifyItemRemoved(i)
    }



}
class ViewHolder(view: View): RecyclerView.ViewHolder(view){
    val fName: TextView = view.findViewById(R.id.fName)
    val lName: TextView = view.findViewById(R.id.lName)
    val cards: CardView = view.findViewById(R.id.cards)

}
