package com.challenge.codewars.plugin.di.dagger

import com.challenge.codewars.plugin.network.Service
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val CODEWARS_URL = "https://www.codewars.com/"

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun providesGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
            .apply { level = HttpLoggingInterceptor.Level.BODY }
    }

    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun providesRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(gsonConverterFactory)
            .baseUrl(CODEWARS_URL)
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun providesService(retrofit: Retrofit): Service {
        return retrofit.create(Service::class.java)
    }
}
