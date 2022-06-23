package com.sanyasdada.cryptocurrency.domain.repository

import com.sanyasdada.cryptocurrency.data.remote.dto.CoinDetailDto
import com.sanyasdada.cryptocurrency.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins():List<CoinDto>

    suspend fun getCoinById(coinId:String):CoinDetailDto
}