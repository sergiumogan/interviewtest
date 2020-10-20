package com.test.myapplication.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("people/")
    fun getPeople(): Single<List<Response>>

}
