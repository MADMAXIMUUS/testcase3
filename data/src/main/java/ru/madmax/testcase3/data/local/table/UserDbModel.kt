package ru.madmax.testcase3.data.local.table

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "USERS")
data class UserDbModel(
    val firstName: String,
    val lastName: String,
    val email: String,

    @PrimaryKey(autoGenerate = true) val id: Int? = null
)
