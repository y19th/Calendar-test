package com.example.calendartest.di

import com.example.calendartest.util.RetrofitBuilder
import com.example.calendartest.data.api.MainApi
import com.example.calendartest.data.repositories.MainRepository
import com.example.calendartest.domain.usecase.MainUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Provides
    fun provideRetrofitBuilder(): RetrofitBuilder {
        return RetrofitBuilder()
    }

    @Provides
    fun provideMainApiInstance(retrofitBuilder: RetrofitBuilder): MainApi {
        return retrofitBuilder.instance(MainApi::class.java)
    }

    @Provides
    fun provideMainRepository(mainApi: MainApi): MainRepository {
        return MainRepository(mainApi)
    }

    @Provides
    fun provideMainUseCase(mainRepository: MainRepository): MainUseCase {
        return MainUseCase(mainRepository)
    }

}