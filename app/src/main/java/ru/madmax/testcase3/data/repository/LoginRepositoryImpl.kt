package ru.madmax.testcase3.data.repository

import ru.madmax.testcase3.data.local.LoginDao
import ru.madmax.testcase3.domain.model.User
import ru.madmax.testcase3.domain.repository.LoginRepository

class LoginRepositoryImpl(
    private val loginDao: LoginDao
) : LoginRepository {

    override suspend fun createUser(user: User) {
        loginDao.createUser(user)
    }

    override suspend fun checkIfExistByEmail(email: String): Boolean {
        return loginDao.checkUserExistByEmail(email)
    }

    override suspend fun checkIfExistByName(name: String): Boolean {
        return loginDao.checkUserExistByName(name)
    }
}