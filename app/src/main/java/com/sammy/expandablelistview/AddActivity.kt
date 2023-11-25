package com.sammy.expandablelistview

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sammy.expandablelistview.databinding.ActivityAddBinding
import com.sammy.expandablelistview.model.User


class AddActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddBinding

    var dataArrayList = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MySharedPreference.init(this)
        dataArrayList.addAll(MySharedPreference.list)

        binding.saveBtn.setOnClickListener {

            val name = binding.toDoName.text.toString()

            val desc = binding.descriptionText.text.toString()

            val degree =binding.degreeSpinner.selectedItem.toString()

            val createDate = binding.createDateText.text.toString()

            val deadline = binding.deadlineText.text.toString()

            dataArrayList.add(User("Open", name, desc, degree, createDate, deadline))
            MySharedPreference.list = dataArrayList

            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()

            finish()

        }

    }
}