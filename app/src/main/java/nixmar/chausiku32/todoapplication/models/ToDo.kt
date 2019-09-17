package nixmar.chausiku32.todoapplication.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "toDo_table")
data class ToDo(@PrimaryKey @ColumnInfo(name = "title") val title : String,
                val description : String,
                var dueDate : String,
                var toDay : String){}
/*
* (name = "id") var id : Int,
* */