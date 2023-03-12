package ru.madmax.testcase3.domain.repository

import ru.madmax.testcase3.domain.model.User

interface LoginRepository {

    suspend fun createUser(user: User)

    suspend fun checkIfExistByEmail(email: String): Boolean

    suspend fun checkIfExistByName(name:String): Boolean
}