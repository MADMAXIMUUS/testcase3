package ru.madmax.testcase3.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "USERS")
data class User(
    val firstName: String,
    val lastName: String,
    val email: String,

    @PrimaryKey(autoGenerate = true) val id: Int? = null
)
