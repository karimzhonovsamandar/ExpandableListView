package com.sammy.expandablelistview.child

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sammy.expandablelistview.MySharedPreference
import com.sammy.expandablelistview.databinding.ActivityFullInformationBinding
import com.sammy.expandablelistview.model.User

class FullInformationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFullInformationBinding

    lateinit var todo: User

    var myTodo = User()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MySharedPreference.init(this)
        todo = intent.getSerializableExtra("title") as User
        val toDoArray = MySharedPreference.list
        binding.descTextView.text = todo.desc
        binding.createDateTextView.text = todo.createDate
        binding.deadlineTextView.text = todo.deadline
        binding.degreeTextView.text = todo.degree

        var index = -1

        for (user in toDoArray) {
            if (user.name == todo.name){
                index = toDoArray.indexOf(user)
                myTodo = user
                supportActionBar?.setTitle(user.name)
                binding.apply {
                    descTextView.text=user.desc
                    degreeTextView.text=user.degree
                    createDateTextView.text=user.createDate
                    deadlineTextView.text=user.deadline

                    when(user.titleName){
                        "Open" -> binding.openCheckBox.isChecked = true
                        "Development" -> binding.developmentCheckBox.isChecked = true
                        "Uploading" -> binding.uploadingCheckBox.isChecked = true
                        "Reject" -> binding.rejectCheckBox.isChecked = true
                        "Close" -> binding.closedCheckBox.isChecked = true
                    }

                }
                break
            }
        }
        binding.acceptBtn.setOnClickListener {
            var parentName = ""
            if (binding.openCheckBox.isChecked) {
                parentName = "Open"
            }
            if (binding.closedCheckBox.isChecked) {
                parentName = "Close"
            }
            if (binding.developmentCheckBox.isChecked) {
                parentName = "Development"
            }
            if (binding.rejectCheckBox.isChecked) {
                parentName = "Reject"
            }
            if (binding.uploadingCheckBox.isChecked) {
                parentName = "Uploading"
            }

            todo.titleName = parentName
            toDoArray[index] = todo
            MySharedPreference.list = toDoArray
            Toast.makeText(this, "Changed", Toast.LENGTH_SHORT).show()
            finish()
        }

    }
}