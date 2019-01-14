package test.interview.uber.com.device.di

import dagger.Binds
import dagger.Module
import test.interview.uber.com.device.services.PreferenceRepositoryImpl
import test.interview.uber.com.domain.repository.PreferenceRepository
import javax.inject.Singleton

@Module
abstract class DeviceModule {

    @Binds
    @Singleton
    abstract fun providePreferenceUtils(preferenceUtilsImpl: PreferenceRepositoryImpl): PreferenceRepository

}