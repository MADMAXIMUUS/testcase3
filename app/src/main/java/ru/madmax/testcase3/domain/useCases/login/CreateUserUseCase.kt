package ru.madmax.testcase3.domain.useCases.login

import ru.madmax.testcase3.domain.model.User
import ru.madmax.testcase3.domain.repository.LoginRepository

class CreateUserUseCase(
    private val repository: LoginRepository
) {
    suspend operator fun invoke(user: User) {
        return repository.createUser(user)
    }
}