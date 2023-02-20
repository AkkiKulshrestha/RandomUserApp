package com.example.randomuser.di

import com.example.randomuser.data.api.contract.RandomUserApi
import com.example.randomuser.data.repository.contract.Repository
import com.example.randomuser.data.repository.impl.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @ViewModelScoped
    @Provides
    fun provideHomeRepository(
        api: RandomUserApi
    ): Repository = RepositoryImpl(api)

}