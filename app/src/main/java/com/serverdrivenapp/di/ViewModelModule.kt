package com.serverdrivenapp.di

import com.serverdrivenapp.data.repositoryImpl.AppRepositoryImpl
import com.serverdrivenapp.domain.repository.AppRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ViewModelModule {

    @Binds
    abstract fun providePostRepository(
        appRepositoryImpl: AppRepositoryImpl
    ): AppRepository

}