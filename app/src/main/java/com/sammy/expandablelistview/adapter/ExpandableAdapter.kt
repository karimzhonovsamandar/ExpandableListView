package com.sammy.expandablelistview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.sammy.expandablelistview.R
import com.sammy.expandablelistview.model.User

class ExpandableAdapter(
    var titleName: ArrayList<String>,
    var map: HashMap<String, ArrayList<User>>
) : BaseExpandableListAdapter() {
    override fun getGroupCount(): Int {
        return titleName.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return map[titleName[groupPosition]]?.size!!
    }

    override fun getGroup(groupPosition: Int): Any {
        return titleName[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        val group = titleName[groupPosition]
        return map[group]?.get(childPosition)!!
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
        val groupItemView : View
        if (convertView!=null){
            groupItemView= convertView
        }
        else{
            groupItemView = LayoutInflater.from(parent?.context).inflate(R.layout.parent_item, parent, false)
        }
        groupItemView.findViewById<TextView>(R.id.rv_parent).text = titleName[groupPosition]

        return groupItemView
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View {
        val groupItemView : View
        if (convertView!=null){
            groupItemView= convertView
        }
        else{
            groupItemView = LayoutInflater.from(parent?.context).inflate(R.layout.child_item, parent, false)
        }
        val f = map[titleName[groupPosition]]?.get(childPosition)
        groupItemView.findViewById<TextView>(R.id.rv_child).text = f!!.name

        return groupItemView
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return true
    }

}