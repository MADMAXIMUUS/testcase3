package ru.madmax.testcase3.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.madmax.testcase3.data.local.table.UserDbModel

@Database(
    entities = [
        UserDbModel::class
    ], version = 1
)
abstract class LocalDatabase : RoomDatabase() {

    abstract val loginDao: LoginDao

    companion object {
        const val NAME = "local_db"
    }
}