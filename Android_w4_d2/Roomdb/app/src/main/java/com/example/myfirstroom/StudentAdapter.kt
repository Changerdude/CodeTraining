package com.example.myfirstroom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class StudentAdapter(private val onClick: (position:Int) -> Unit
                     , private val studentList: List<Students>): RecyclerView.Adapter<ViewHolder>() {
    //Make our student list a mutable list to manipulate
   private var mStudentList: MutableList<Students> = studentList as MutableList<Students>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //inflate
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_list_layout, parent, false)
        return ViewHolder(view, onClick)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //add element to view holder
        val itemVM = studentList[position]
        holder.fName.text = itemVM.firstName
        holder.lName.text = itemVM.lastName
        //click listener for cards(Bad practice because it adds a listener to each object vs the view
        // and passing the location so it only uses one listener)
//        holder.cards.setOnClickListener{
//            val intent = Intent(holder.cards.context, UpdateStudent::class.java)
//            intent.putExtra("student", itemVM)
//
//            holder.cards.context.startActivity(intent)
//        }
    }

    override fun getItemCount(): Int {
        //size of the list/data source
        return studentList.size
    }
        //delete item from both repo and the mutable list, then notify the adapter of the change
    fun deleteItem(i : Int, vm: MyViewModel){
        vm.deleteStudent(studentList[i])
        notifyItemRemoved(i)
    }


}
class ViewHolder(view: View, private val onClick: (position: Int) -> Unit)
    : RecyclerView.ViewHolder(view), View.OnClickListener{
    init{
        itemView.setOnClickListener(this)
    }
    val fName: TextView = view.findViewById(R.id.fName)
    val lName: TextView = view.findViewById(R.id.lName)
    override fun onClick(v: View?) {
        val position = adapterPosition
        onClick(position)
    }

}

