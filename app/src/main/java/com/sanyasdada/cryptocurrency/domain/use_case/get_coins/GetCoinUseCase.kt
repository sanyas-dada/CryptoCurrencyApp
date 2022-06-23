package com.sanyasdada.cryptocurrency.domain.use_case.get_coins

import com.sanyasdada.cryptocurrency.common.Resource
import com.sanyasdada.cryptocurrency.data.remote.dto.toCoin
import com.sanyasdada.cryptocurrency.data.remote.dto.toCoinDetail
import com.sanyasdada.cryptocurrency.domain.model.Coin
import com.sanyasdada.cryptocurrency.domain.model.CoinDetail
import com.sanyasdada.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId:String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId = coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected things happened"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>("Couldn't reach server.Check your internet connection"))
        }

    }
}