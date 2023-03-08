package ru.madmax.testcase3.domain.useCases.login

data class LoginUseCases(
    val createUserUseCase: CreateUserUseCase,
    val checkUserExistByEmail: CheckUserExistByEmail,
    val checkUserExistByName: CheckUserExistByName
)
