package ru.madmax.testcase3.domain.useCase

data class LoginUseCases(
    val createUserUseCase: CreateUserUseCase,
    val checkUserExistByEmailUseCase: CheckUserExistByEmailUseCase,
    val checkUserExistByNameUseCase: CheckUserExistByNameUseCase
)
