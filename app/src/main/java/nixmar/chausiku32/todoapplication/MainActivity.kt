package nixmar.chausiku32.todoapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.activity_main.*
import nixmar.chausiku32.todoapplication.adapters.ToDoAdapter
import nixmar.chausiku32.todoapplication.adapters.ToDoListAdapter
import nixmar.chausiku32.todoapplication.models.ToDo
import nixmar.chausiku32.todoapplication.viewModels.ToDoViewModel

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class MainActivity : AppCompatActivity() {

    private lateinit var toDoViewModel: ToDoViewModel
    var toDoList = ArrayList<ToDo>()
    val adapter = ToDoAdapter()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerTodoListView)
  /*      val adapter = ToDoListAdapter(this)
        recyclerView.adapter = adapter*/
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

/*        var intent = Intent()
        var title: String = intent.getStringExtra(NewToDo.EXTRA_TITLE)
        var description: String = intent.getStringExtra(NewToDo.EXTRA_DESCRIPTION)
        var dueDate: String = intent.getStringExtra(NewToDo.EXTRA_DUEDATE)
        var toDay: String = intent.getStringExtra(NewToDo.EXTRA_TODAY)

        var todo = ToDo(title, description, dueDate,toDay )
        toDoList.add(todo)
        adapter.submitList(toDoList)*/

        toDoViewModel = ViewModelProviders.of(this).get(ToDoViewModel::class.java)
        toDoViewModel.allToDos.observe(this, Observer { toDos ->    ///.observe(viewLifeCycleOwner, )
            toDos?.let { adapter.setToDos(it) }
        })

        fab.setOnClickListener { view ->
            intent = Intent(this@MainActivity, NewToDo::class.java)
            startActivityForResult(intent, newTodoActivityRequestCode)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == newTodoActivityRequestCode && resultCode == Activity.RESULT_OK){
            data?.let {

                var title: String = data.getStringExtra(NewToDo.EXTRA_TITLE)
                var description: String = data.getStringExtra(NewToDo.EXTRA_DESCRIPTION)
                var dueDate: String = data.getStringExtra(NewToDo.EXTRA_DUEDATE)
                var toDay: String = data.getStringExtra(NewToDo.EXTRA_TODAY)

                @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS") var toDo = ToDo(title, description, dueDate, toDay)
                toDoList.add(toDo)
                adapter.submitList(toDoList)
                toDoViewModel.insert(toDo)
            }
        }
        else{
            Toast.makeText(
                applicationContext,
                "ToDo not saved because it is empty.",
                Toast.LENGTH_LONG).show()
        }
    }

    companion object {
        const val newTodoActivityRequestCode = 1
    }
}
/*
                val todoTitle = ToDo(it.getStringExtra(NewToDo.EXTRA_TITLE))
                val todoDescription = ToDo(it.getStringExtra(NewToDo.EXTRA_DESCRIPTION))
                val todoDueDate = ToDo(it.getStringExtra(NewToDo.EXTRA_DUEDATE))
                val todoToday = ToDo(it.getStringExtra(NewToDo.EXTRA_TODAY))
*/

//toDo = ToDo(todoTitle, todoDescription, todoDueDate, todoToday)

/*                toDoViewModel.insert(todoTitle)
                toDoViewModel.insert(todoDescription)
                toDoViewModel.insert(todoDueDate)
                toDoViewModel.insert(todoToday)*/
/*var title: String = it.getStringExtra(NewToDo.EXTRA_TITLE)
                var description =  it.getStringExtra(NewToDo.EXTRA_DESCRIPTION)
                var dueDate = it.getStringExtra(NewToDo.EXTRA_DUEDATE)
                var today: String = it.getStringExtra(NewToDo.EXTRA_TODAY)*/
/*
* it.getStringExtra(NewToDo.EXTRA_TITLE), it.getStringExtra(NewToDo.EXTRA_DESCRIPTION), it.getStringExtra(NewToDo.EXTRA_DUEDATE), it.getStringExtra(NewToDo.EXTRA_TODAY)
*
* title, description, dueDate, today
* */