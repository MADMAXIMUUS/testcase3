package ru.madmax.testcase3.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.madmax.testcase3.domain.repository.HomeRepository
import ru.madmax.testcase3.domain.useCase.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainRemoteModule {

    @Provides
    @Singleton
    fun provideHomeUseCases(repository: HomeRepository): GetLatestUseCase {
        return GetLatestUseCase(repository)
    }
}