package com.marco.portifoliocurrencyconverter.main


import com.marco.portifoliocurrencyconverter.data.CurrencyApi
import com.marco.portifoliocurrencyconverter.data.models.CurrencyResponse
import com.marco.portifoliocurrencyconverter.util.Resource
import javax.inject.Inject

class DefaultMainRepository @Inject constructor(
    private val api: CurrencyApi
) : MainRepository {

    override suspend fun getRates(base: String): Resource<CurrencyResponse> {
        return try {
            val response = api.getRates(base)
            val result = response.body()
            if(response.isSuccessful && result != null) {
                Resource.Success(result)
            } else {
                Resource.Error(response.message())
            }
        } catch(e: Exception) {
            Resource.Error(e.message ?: "An error occured")
        }
    }
}