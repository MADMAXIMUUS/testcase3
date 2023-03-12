package ru.madmax.testcase3.domain.useCase

import ru.madmax.testcase3.domain.repository.LoginRepository

class CheckUserExistByEmailUseCase(
    private val repository: LoginRepository
) {
    suspend operator fun invoke(email: String): Boolean {
        return repository.checkIfExistByEmail(email)
    }
}
