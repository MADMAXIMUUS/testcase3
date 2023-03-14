package ru.madmax.testcase3.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.madmax.testcase3.data.remote.MainApi
import ru.madmax.testcase3.data.repository.HomeRepositoryImpl
import ru.madmax.testcase3.data.util.BASE_URL
import ru.madmax.testcase3.domain.repository.HomeRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataRemoteModule {

    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient {
        return OkHttpClient
            .Builder()
            .build()
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    fun provideGifApi(client: OkHttpClient): MainApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(client)
            .build()
            .create(MainApi::class.java)
    }

    @Provides
    @Singleton
    fun provideHomeRepository(mainApi: MainApi): HomeRepository {
        return HomeRepositoryImpl(mainApi)
    }
}