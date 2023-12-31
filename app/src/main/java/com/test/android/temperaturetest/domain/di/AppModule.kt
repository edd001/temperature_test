package com.test.android.temperaturetest.domain.di

import android.app.Application
import android.content.Context
import com.test.android.temperaturetest.domain.repository.TemperatureRepository
import com.test.android.temperaturetest.domain.repository.TemperatureRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideContext(application: Application): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideTemperatureRepository(
        context: Context
    ): TemperatureRepository {
        return TemperatureRepositoryImpl(
            context
        )
    }
}