package com.sanyasdada.cryptocurrency.data.repository

import com.sanyasdada.cryptocurrency.data.remote.CoinPaprikaApi
import com.sanyasdada.cryptocurrency.data.remote.dto.CoinDetailDto
import com.sanyasdada.cryptocurrency.data.remote.dto.CoinDto
import com.sanyasdada.cryptocurrency.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
):CoinRepository
{
    override suspend fun getCoins(): List<CoinDto> {
        // it returns the list of the coins
        return api.getCoin()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        // it returns the details of each coins
        return  api.getCoinsById(coinId = coinId)
    }

}