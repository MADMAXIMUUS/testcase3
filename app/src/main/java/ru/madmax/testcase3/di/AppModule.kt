package ru.madmax.testcase3.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.madmax.testcase3.data.local.LocalDatabase
import ru.madmax.testcase3.data.repository.LoginRepositoryImpl
import ru.madmax.testcase3.domain.repository.LoginRepository
import ru.madmax.testcase3.domain.useCases.login.CheckUserExistByEmail
import ru.madmax.testcase3.domain.useCases.login.CheckUserExistByName
import ru.madmax.testcase3.domain.useCases.login.CreateUserUseCase
import ru.madmax.testcase3.domain.useCases.login.LoginUseCases
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMadNoteDatabase(
        app: Application
    ): LocalDatabase {
        return Room.databaseBuilder(
            app,
            LocalDatabase::class.java,
            LocalDatabase.NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideLoginRepository(db: LocalDatabase): LoginRepository {
        return LoginRepositoryImpl(db.loginDao)
    }

    @Provides
    @Singleton
    fun provideLoginUseCases(repository: LoginRepository): LoginUseCases {
        return LoginUseCases(
            createUserUseCase = CreateUserUseCase(repository),
            checkUserExistByEmail = CheckUserExistByEmail(repository),
            checkUserExistByName = CheckUserExistByName(repository)
        )
    }
}