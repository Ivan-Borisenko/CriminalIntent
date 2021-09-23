package com.example.criminalintent

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
//формат хранения преступлений в БД: UUID-номер; title-текст преступления; date-дата; isSolved-статус раскрытия; suspect-имя подозреваемого
data class Crime(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    var title: String = "",
    var date: Date = Date(),
    var isSolved: Boolean = false,
    var suspect: String = ""
) {
    val photoFileName
        get() = "IMG_$id.jpg"
}