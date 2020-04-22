package com.candy.caishenaccountbook.bean

class Record {
    val TYPE_BORROW = 0
    val TYPE_LOAN = 1

    var type = 0
    var name: String? = null
    var count = 0f
    var rate = 0f
    var borrowTime: Long = 0
    var returnTime: Long = 0
    var photos: List<String>? = null
    var note: String? = null
}