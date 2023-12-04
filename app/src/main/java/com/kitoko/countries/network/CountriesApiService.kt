package com.kitoko.countries.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://restcountries.com/v3.1/"
private const val URL = "https://restcountries.com/v3.1/name/"

// Builds and create a retrofit object
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(URL).build()

/**
 * The following interface defines how retrofit will be talking to the server using http
 */
interface CountriesApiService {
    @GET("drc")
    suspend fun getAll(): String
}

/**
 * The following defines a public and unique retrofit object that will be used oll over the app
 */
object CountriesApi {

    val retrofitService: CountriesApiService by lazy {
        retrofit.create(CountriesApiService::class.java)
    }
}