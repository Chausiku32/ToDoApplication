package nixmar.chausiku32.todoapplication.viewHolders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import nixmar.chausiku32.todoapplication.R
import nixmar.chausiku32.todoapplication.models.ToDo

class ViewHolderToDo(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(toDo: ToDo){
        itemView.findViewById<TextView>(R.id.txtTitle).setText(toDo.title)
        itemView.findViewById<TextView>(R.id.txtDecription).setText(toDo.description)
        itemView.findViewById<TextView>(R.id.txtDueDate).setText(toDo.dueDate)
        itemView.findViewById<TextView>(R.id.txtToDay).setText(toDo.toDay)
    }

}