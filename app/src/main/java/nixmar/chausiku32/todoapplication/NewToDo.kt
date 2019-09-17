package nixmar.chausiku32.todoapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.Toast
class NewToDo : AppCompatActivity() {

    private lateinit var title: EditText
    private lateinit var description: EditText
    private lateinit var dueDate: EditText
    private lateinit var today: EditText
    private lateinit var date: CalendarView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_to_do)

        title = findViewById(R.id.edtTextTitle)
        description = findViewById(R.id.edtTextDescription)
        dueDate = findViewById(R.id.edtTextDueDate)
        today = findViewById(R.id.edtTextToday)
        date = findViewById(R.id.calendarToDoView)

/*
        dueDate.setOnClickListener {
            date.isClickable = true
            val todayDate: String = date.toString()
            date.isClickable = false
            dueDate.setText(todayDate)
        }
*/


        val btnOk = findViewById<Button>(R.id.btnSubmit)
        btnOk.setOnClickListener{
            val submitIntent = Intent()
            if(TextUtils.isEmpty(title.text) || TextUtils.isEmpty(description.text) || TextUtils.isEmpty(dueDate.text) || TextUtils.isEmpty(today.text)){
                setResult(Activity.RESULT_CANCELED, submitIntent)
                Toast.makeText(this, "Cannot submit empty value(s)", Toast.LENGTH_SHORT).show()
            }
            else {
                val toDoTitle = title.text.toString()
                val toDoDescription = description.text.toString()
                val toDoDueDate = dueDate.text.toString()
                val toDoToday = today.text.toString()
/*                val todoDate = date.toString()*/

                submitIntent.putExtra(EXTRA_TITLE, toDoTitle)
                submitIntent.putExtra(EXTRA_DESCRIPTION, toDoDescription)
                submitIntent.putExtra(EXTRA_DUEDATE, toDoDueDate)
                submitIntent.putExtra(EXTRA_TODAY, toDoToday)
                setResult(Activity.RESULT_OK, submitIntent)
            }
            finish()
        }
    }

    companion object{
        const val EXTRA_TITLE = "nixmar.chausiku32.todoapplication.models.ToDo.title"
        const val EXTRA_DESCRIPTION = "nixmar.chausiku32.todoapplication.models.ToDo.description"
        const val EXTRA_DUEDATE = "nixmar.chausiku32.todoapplication.models.ToDo.duedate"
        const val EXTRA_TODAY = "nixmar.chausiku32.todoapplication.models.ToDo.today"
    }
}