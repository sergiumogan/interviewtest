package com.test.myapplication.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RestClient private constructor() {

    companion object {

        fun create(): ApiService {

            val logging = HttpLoggingInterceptor()
            val httpClient = OkHttpClient.Builder()

            httpClient.addInterceptor {
                var request = it.request()

                request = request.newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Accept-Language", "en")
                    .build()

                it.proceed(request)
            }

            logging.level = HttpLoggingInterceptor.Level.BODY
            httpClient.addInterceptor(logging)

            val client = httpClient.build()

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://swapi.dev/api/")
                .client(client)
                .build()

            return retrofit.create(ApiService::class.java)
        }

    }

}
