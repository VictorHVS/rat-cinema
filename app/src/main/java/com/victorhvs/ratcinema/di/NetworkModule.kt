package com.victorhvs.ratcinema.di

import androidx.paging.ExperimentalPagingApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.victorhvs.ratcinema.data.local.RatCinemaDatabase
import com.victorhvs.ratcinema.data.remote.TmdbApi
import com.victorhvs.ratcinema.data.repository.RemoteDataSourceImpl
import com.victorhvs.ratcinema.domain.repository.RemoteDataSource
import com.victorhvs.ratcinema.util.ApiInterceptor
import com.victorhvs.ratcinema.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@ExperimentalPagingApi
@ExperimentalSerializationApi
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideInterceptor(): ApiInterceptor {
        return ApiInterceptor()
    }

    @Provides
    @Singleton
    fun provideHttpClient(apiInterceptor: ApiInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(apiInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
        val contentType = MediaType.get("application/json")
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .build()
    }

    @Provides
    @Singleton
    fun provideTmdbApi(retrofit: Retrofit): TmdbApi {
        return retrofit.create(TmdbApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(
        tmdbApi: TmdbApi,
        ratCinemaDatabase: RatCinemaDatabase
    ): RemoteDataSource {
        return RemoteDataSourceImpl(
            tmdbApi = tmdbApi,
            ratCinemaDatabase = ratCinemaDatabase
        )
    }
}