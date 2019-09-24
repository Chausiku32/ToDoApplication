package nixmar.chausiku32.todoapplication.interfaces

import androidx.lifecycle.LiveData
import androidx.room.*
import nixmar.chausiku32.todoapplication.models.ToDo

@Dao
interface ToDoDAO {
    @Query("SELECT * FROM toDo_table ORDER BY title ASC")
    fun getAllTodos(): LiveData<List<ToDo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(toDo: ToDo)

    @Query("DELETE FROM toDo_table")
    suspend fun deleteAll()

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(toDo: ToDo)


}

/*  @Delete()
    suspend fun deleteById()

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(toDo: ToDo){}

    @Query()
    suspend fun getTodoById()

        @Query("SELECT * FROM toDo_table WHERE title == %s", id)
    suspend fun getTodoById(String id)
    */
