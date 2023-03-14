package ru.madmax.testcase3.domain.useCase

import ru.madmax.testcase3.domain.repository.LoginRepository

class CheckUserExistByNameUseCase(
    private val repository: LoginRepository
) {
    suspend operator fun invoke(name: String): Boolean {
        return repository.checkIfExistByName(name)
    }
}
