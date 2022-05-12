package net.swift.android_paging_3_sample.service.api

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitBuilder {
    private val builder = Retrofit.Builder()
    var retrofit: Retrofit

    init {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BASIC
        val client = OkHttpClient.Builder().addInterceptor(logging).build()
        val moshi = Moshi.Builder().build()
        retrofit = builder.baseUrl(BASE_URL).client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi)).build()
    }

    fun <T> getService(service: Class<T>): T {
        return retrofit.create(service)
    }

    companion object {
        const val BASE_URL = "https://api.github.com/"
    }

}