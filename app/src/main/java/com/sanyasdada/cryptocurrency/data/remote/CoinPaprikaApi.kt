package com.sanyasdada.cryptocurrency.data.remote

import com.sanyasdada.cryptocurrency.data.remote.dto.CoinDetailDto
import com.sanyasdada.cryptocurrency.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoin(): List<CoinDto>

    @GET("v1/coins/{coinId}")
    suspend fun getCoinsById(@Path("coinId") coinId: String):CoinDetailDto
    companion object {
        const val BASE_URL = "https://api.coinpaprika.com/"
    }
}