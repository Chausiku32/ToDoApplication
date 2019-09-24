package nixmar.chausiku32.todoapplication.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import nixmar.chausiku32.todoapplication.interfaces.ToDoDAO
import nixmar.chausiku32.todoapplication.models.ToDo

@Database(entities = [ToDo::class], version = 1, exportSchema = false)
abstract class ToDoRoomDatabase : RoomDatabase() {

    abstract fun toDoDao(): ToDoDAO

    private class ToDoDatabaseCallback(val scope: CoroutineScope): RoomDatabase.Callback(){
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { toDoRoomDatabase ->
                scope.launch {
                    populateDatabase(toDoRoomDatabase.toDoDao())
                }
            }
        }

        suspend fun populateDatabase(toDoDAO: ToDoDAO){
            //clear all the content
            toDoDAO.deleteAll()

            //add sample words
            val todo = ToDo("Jambo", "Hakuna Matata", "21/09/2019", "16/09/2019")
            toDoDAO.insert(todo)

            val todo_Too = ToDo("Recycler View", "Use Recycler View.List Adapter", "17/09/2019", "16/09/2019")
            toDoDAO.insert(todo_Too)
        }

    }

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: ToDoRoomDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): ToDoRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ToDoRoomDatabase::class.java,
                    "todo_database"
                ).addCallback(ToDoDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
