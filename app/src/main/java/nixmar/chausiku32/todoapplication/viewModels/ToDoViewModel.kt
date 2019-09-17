package nixmar.chausiku32.todoapplication.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import nixmar.chausiku32.todoapplication.db.ToDoRoomDatabase
import nixmar.chausiku32.todoapplication.models.ToDo
import nixmar.chausiku32.todoapplication.repositories.ToDoRepository

class ToDoViewModel(application: Application) : AndroidViewModel(application){

    private var repository : ToDoRepository

    val allToDos: LiveData<List<ToDo>>

    init {
        val toDosDao = ToDoRoomDatabase.getDatabase(application, viewModelScope).toDoDao()
        repository = ToDoRepository(toDosDao)
        allToDos = repository.allToDos
    }

    fun insert(toDo: ToDo) = viewModelScope.launch {
        repository.insert(toDo)
    }

    fun deleteAll() = viewModelScope.launch {
        repository.deleteAll()
    }
}

/*    fun update(toDo: ToDo) = viewModelScope.launch {
        repository.update(toDo)
    }*/