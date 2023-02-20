package com.example.randomuser.di

import com.example.randomuser.data.api.contract.RandomUserApi
import com.example.randomuser.data.api.impl.RandomUserApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideOMDbApi(client: HttpClient): RandomUserApi = RandomUserApiImpl(client)

}