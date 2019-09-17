package nixmar.chausiku32.todoapplication.repositories

import androidx.lifecycle.LiveData
import nixmar.chausiku32.todoapplication.interfaces.ToDoDAO
import nixmar.chausiku32.todoapplication.models.ToDo

class ToDoRepository(private val toDoDao: ToDoDAO) {

    val allToDos : LiveData<List<ToDo>> = toDoDao.getAllTodos()

    suspend fun insert(toDo: ToDo){
        toDoDao.insert(toDo)
    }

    suspend fun deleteAll(){
        toDoDao.deleteAll()
    }
}

/*    suspend fun update(toDo : ToDo){
        toDoDao.update(toDo)
    }*/
