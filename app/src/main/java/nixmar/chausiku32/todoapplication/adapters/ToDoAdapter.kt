package nixmar.chausiku32.todoapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import nixmar.chausiku32.todoapplication.R
import nixmar.chausiku32.todoapplication.models.ToDo
import nixmar.chausiku32.todoapplication.viewHolders.ViewHolderToDo

class ToDoAdapter : ListAdapter<ToDo, ViewHolderToDo>(object : DiffUtil.ItemCallback<ToDo>() {

    override fun areItemsTheSame(oldItem: ToDo, newItem: ToDo): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return true
    }

    override fun areContentsTheSame(oldItem: ToDo, newItem: ToDo): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return true
    }

}) {

    private var toDos = emptyList<ToDo>()

    override fun onBindViewHolder(holder: ViewHolderToDo, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderToDo{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return ViewHolderToDo(view)
    }

    internal fun setToDos(toDos: List<ToDo>) {
        this.toDos = toDos
        notifyDataSetChanged()
    }

}