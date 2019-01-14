package test.interview.uber.com.data.di

import dagger.Binds
import dagger.Module
import test.interview.uber.com.data.services.ApiRepositoryImpl
import test.interview.uber.com.domain.repository.ApiRepository
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
abstract class DataModule{
    @Binds
    @Singleton
    abstract fun provideApiRepository(apiRepositoryImpl: ApiRepositoryImpl): ApiRepository // why is this provided here?
}