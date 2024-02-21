package com.example.calendartest.util.extenstion

fun <T> List<T>.toIterableString(): String {
    val string = StringBuilder()

    this.forEachIndexed { index, item ->
        if(index < this.size - 1) {
            string.append(item.toString() + ", ")
        } else string.append(item.toString())
    }
    return string.toString()
}