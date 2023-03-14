package ru.madmax.testcase3.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.madmax.testcase3.data.local.table.UserDbModel

@Dao
interface LoginDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createUser(userDbModel: UserDbModel)

    @Query("SELECT EXISTS(SELECT * FROM USERS WHERE email = :email)")
    suspend fun checkUserExistByEmail(email: String): Boolean

    @Query("SELECT EXISTS(SELECT * FROM USERS WHERE firstName = :name)")
    suspend fun checkUserExistByName(name: String): Boolean
}