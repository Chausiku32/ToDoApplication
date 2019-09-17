package nixmar.chausiku32.todoapplication.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import nixmar.chausiku32.todoapplication.R
import nixmar.chausiku32.todoapplication.models.ToDo

class ToDoListAdapter internal constructor(context: Context) : RecyclerView.Adapter<ToDoListAdapter.ToDoViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var toDos = emptyList<ToDo>()

    inner class ToDoViewHolder( itemView: View) : RecyclerView.ViewHolder(itemView){
        val toDoTitleItemView : TextView = itemView.findViewById(R.id.txtTitle)
        val toDoDescriptionItemView : TextView = itemView.findViewById(R.id.txtDecription)
        val toDoDueDateItemView : TextView = itemView.findViewById(R.id.txtDueDate)
        val toDoToDayItemView : TextView = itemView.findViewById(R.id.txtToDay)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return ToDoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val current = toDos[position]
        holder.toDoTitleItemView.text = current.title
        holder.toDoDescriptionItemView.text = current.description
        holder.toDoDueDateItemView.text = current.dueDate
        holder.toDoToDayItemView.text = current.toDay
    }

    internal fun setToDos(toDos: List<ToDo>) {
        this.toDos = toDos
        notifyDataSetChanged()
    }

    override fun getItemCount() = toDos.size
}


/*        val toDoDueDateItemView : Date = Date.parse((R.id.txtDueDate).toString(), DateTimeFormatter.ISO_DATE)
        val toDoToDayItemView : Date = LocalDate.parse((R.id.txtDueDate).toString(), DateTimeFormatter.ISO_DATE)*/