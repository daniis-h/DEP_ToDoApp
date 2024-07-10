package java.a1.deptask1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import data.Task
import data.TaskViewMddel


class Activity_showlist : AppCompatActivity() {

    private val taskViewModel: TaskViewMddel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_showlist)

        val container = findViewById<LinearLayout>(R.id.insertRecent2)
        container.removeAllViews()

        // Inflate each task item and add it to the container
        taskViewModel.readAllData.observe(this, Observer { tasks ->
            tasks?.let {
                for (task in it) {
                    addTaskToContainer(container, task)
                }
            }
        })
    }

    private fun addTaskToContainer(container: LinearLayout, task: Task) {
        val inflater = LayoutInflater.from(this)
        val taskView: View = inflater.inflate(R.layout.task_list, container, false)

        // Set task data to the views
        taskView.findViewById<TextView>(R.id.task).text = task.detail
        taskView.findViewById<TextView>(R.id.time).text = task.time

        // Handle edit and delete operations
        taskView.findViewById<ImageView>(R.id.change).setOnClickListener {
            // Handle edit task
        }

        taskView.findViewById<ImageView>(R.id.done).setOnClickListener {
            // Handle delete task
            taskViewModel.deleteTask(task)
        }

        container.addView(taskView)
    }
}
