package com.marco.portifoliocurrencyconverter.main

import com.marco.portifoliocurrencyconverter.data.models.CurrencyResponse
import com.marco.portifoliocurrencyconverter.util.Resource


interface MainRepository {

    suspend fun getRates(base: String): Resource<CurrencyResponse>
}