package com.sammy.expandablelistview.model

import java.io.Serializable

class User : Serializable{

    var titleName: String = ""
    var name: String = ""
    var desc: String = ""
    var degree: String = ""
    var createDate: String = ""
    var deadline: String = ""


    constructor(name: String, desc: String, degree: String, createDate: String, deadline: String) {
        this.name = name
        this.desc = desc
        this.degree = degree
        this.createDate = createDate
        this.deadline = deadline
    }

    constructor(name: String) {
        this.name = name
    }

    constructor(
        titleName: String,
        name: String,
        desc: String,
        degree: String,
        createDate: String,
        deadline: String
    ) {
        this.titleName = titleName
        this.name = name
        this.desc = desc
        this.degree = degree
        this.createDate = createDate
        this.deadline = deadline
    }

    constructor()
}