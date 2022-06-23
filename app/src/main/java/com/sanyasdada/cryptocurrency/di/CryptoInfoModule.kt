package com.sanyasdada.cryptocurrency.di

import com.google.gson.GsonBuilder
import com.sanyasdada.cryptocurrency.data.remote.CoinPaprikaApi
import com.sanyasdada.cryptocurrency.data.repository.CoinRepositoryImpl
import com.sanyasdada.cryptocurrency.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object CryptoInfoModule {



   @Provides
   @Singleton // there is a single instance throughout our whole app.
   fun provideCoinRepository(
       api:CoinPaprikaApi
   ):CoinRepository{
       return CoinRepositoryImpl(api)
   }


    @Provides
    @Singleton
    fun provideCoinPaprikaApi():CoinPaprikaApi{
        return Retrofit.Builder()
            .baseUrl(CoinPaprikaApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }
}