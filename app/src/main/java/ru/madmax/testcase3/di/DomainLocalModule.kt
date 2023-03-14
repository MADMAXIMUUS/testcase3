package ru.madmax.testcase3.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.madmax.testcase3.domain.repository.LoginRepository
import ru.madmax.testcase3.domain.useCase.CheckUserExistByEmailUseCase
import ru.madmax.testcase3.domain.useCase.CheckUserExistByNameUseCase
import ru.madmax.testcase3.domain.useCase.CreateUserUseCase
import ru.madmax.testcase3.domain.useCase.LoginUseCases
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainLocalModule {

    @Provides
    @Singleton
    fun provideLoginUseCases(repository: LoginRepository): LoginUseCases {
        return LoginUseCases(
            createUserUseCase = CreateUserUseCase(repository),
            checkUserExistByEmailUseCase = CheckUserExistByEmailUseCase(repository),
            checkUserExistByNameUseCase = CheckUserExistByNameUseCase(repository)
        )
    }
}