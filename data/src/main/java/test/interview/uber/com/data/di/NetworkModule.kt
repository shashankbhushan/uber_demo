package test.interview.uber.com.data.di

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import test.interview.uber.com.data.BuildConfig
import test.interview.uber.com.data.constants.Urls
import test.interview.uber.com.data.services.ApiService
import test.interview.uber.com.domain.repository.PreferenceRepository
import timber.log.Timber
import javax.inject.Singleton

@Module
class NetworkModule{
    @Provides
    fun provideOkHttpClient(preferenceUtils: PreferenceRepository): OkHttpClient {
        val okHttpBuilder =  OkHttpClient.Builder()
        if(BuildConfig.DEBUG) {
            okHttpBuilder.addNetworkInterceptor(StethoInterceptor())
            val loggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> Timber.i(message) })
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            okHttpBuilder.addInterceptor(loggingInterceptor)
        }
        return  okHttpBuilder.build()
    }




    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder()
            .setLenient()
            .create()
    }


    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Urls.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    }

    @Provides
    @Singleton
    fun provideTutorApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}