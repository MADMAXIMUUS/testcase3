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
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataLocalModule {

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
}