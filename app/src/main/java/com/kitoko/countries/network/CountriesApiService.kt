package com.kitoko.countries.network

import com.kitoko.countries.model.Country
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://restcountries.com/v3.1"

// Builds and create a retrofit object
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL).build()

/**
 * The following interface defines how retrofit will be talking to the server using http
 */
interface CountriesApiService {
    @GET("all")
    suspend fun getAll(): List<Country>
}

/**
 * The following defines a public and unique retrofit object that will be used oll over the app
 */
object CountriesApi {

    val retrofitService: CountriesApiService by lazy {
        retrofit.create(CountriesApiService::class.java)
    }
}