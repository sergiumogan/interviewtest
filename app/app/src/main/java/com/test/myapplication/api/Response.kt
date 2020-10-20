package com.test.myapplication.api

import com.google.gson.annotations.SerializedName
import com.test.myapplication.models.Person

data class Response (
    @SerializedName("count") val count: Int = 0,
    @SerializedName("next") val next: String = "",
    @SerializedName("previous") val previous: String = "",
    @SerializedName("result") val result: List<Person> = emptyList(),
    )
