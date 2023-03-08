package ru.madmax.testcase3.domain.useCases.login

import ru.madmax.testcase3.domain.repository.LoginRepository

class CheckUserExistByName(
    private val repository: LoginRepository
) {
    suspend operator fun invoke(name: String): Boolean {
        return repository.checkIfExistByName(name)
    }
}
