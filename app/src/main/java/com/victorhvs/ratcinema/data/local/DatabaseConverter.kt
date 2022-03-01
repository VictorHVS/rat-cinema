package com.victorhvs.ratcinema.data.local

import androidx.room.TypeConverter
import java.lang.StringBuilder

class DatabaseConverter {

    private val separator = ","

    @TypeConverter
    fun convertListToString(list: List<Int>): String {
        if (list.isEmpty()) return ""

        val stringBuilder = StringBuilder()
        for (item in list) {
            stringBuilder.append(item).append(separator)
        }

        stringBuilder.setLength(stringBuilder.length - separator.length)
        return stringBuilder.toString()
    }

    @TypeConverter
    fun convertStringToList(string: String): List<Int> {
        if (string.isEmpty()) return emptyList()
        return string.split(separator).map { it.toInt() }
    }
}