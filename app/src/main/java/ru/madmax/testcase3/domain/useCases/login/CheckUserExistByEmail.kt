package ru.madmax.testcase3.domain.useCases.login

import ru.madmax.testcase3.domain.repository.LoginRepository

class CheckUserExistByEmail(
    private val repository: LoginRepository
) {
    suspend operator fun invoke(email: String): Boolean {
        return repository.checkIfExistByEmail(email)
    }
}
