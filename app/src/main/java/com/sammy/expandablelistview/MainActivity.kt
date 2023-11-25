package com.sammy.expandablelistview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sammy.expandablelistview.adapter.ExpandableAdapter
import com.sammy.expandablelistview.child.FullInformationActivity
import com.sammy.expandablelistview.databinding.ActivityMainBinding
import com.sammy.expandablelistview.model.User

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var map: HashMap<String, ArrayList<User>>
    private lateinit var titleName: ArrayList<String>

    lateinit var openArrayList: ArrayList<User>
    lateinit var devArrayList: ArrayList<User>
    lateinit var uploadArrayList: ArrayList<User>
    lateinit var rejectArrayList: ArrayList<User>
    lateinit var closedArrayList: ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MySharedPreference.init(this)
        binding.expandableList.setOnChildClickListener { expandableListView, view, groupPosition, childPosition, l ->
            val intent = Intent(this, FullInformationActivity::class.java)
            intent.putExtra("title", map[titleName[groupPosition]]?.get(childPosition))
            startActivity(intent)
            true
        }

    }

    private fun objects() {
        map = HashMap()
        titleName = ArrayList()
        titleName.add("Open")
        titleName.add("Development")
        titleName.add("Uploading")
        titleName.add("Reject")
        titleName.add("Close")


        openArrayList = ArrayList()
        devArrayList= ArrayList()
        uploadArrayList= ArrayList()
        rejectArrayList= ArrayList()
        closedArrayList= ArrayList()

        var addTodoChildArray = MySharedPreference.list

        for (user in addTodoChildArray) {

            if (user.titleName == "Open") {
                openArrayList.add(user)
            }
            if (user.titleName == "Development") {
                devArrayList.add(user)
            }
            if (user.titleName == "Uploading") {
                uploadArrayList.add(user)
            }
            if (user.titleName == "Reject") {
                rejectArrayList.add(user)
            }
            if (user.titleName == "Close") {
                closedArrayList.add(user)
            }
        }

        map[titleName[0]] = openArrayList
        map[titleName[1]] = devArrayList
        map[titleName[2]] = uploadArrayList
        map[titleName[3]] = rejectArrayList
        map[titleName[4]] = closedArrayList

    }

    override fun onStart() {
        super.onStart()
        MySharedPreference.init(this)
        objects()
        val adapter = ExpandableAdapter(titleName, map)
        binding.expandableList.setAdapter(adapter)

    }

}