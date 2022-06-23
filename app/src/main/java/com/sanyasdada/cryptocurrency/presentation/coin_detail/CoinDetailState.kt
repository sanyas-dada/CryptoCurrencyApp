package com.sanyasdada.cryptocurrency.presentation.coin_detail

import com.sanyasdada.cryptocurrency.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading:Boolean = false,
    val coin:CoinDetail? = null,
    val error:String =""
)
