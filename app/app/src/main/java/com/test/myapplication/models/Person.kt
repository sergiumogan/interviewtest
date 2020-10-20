package com.test.myapplication.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "persons")
data class Person (
    @field:SerializedName("name") val name: String = "",
    @field:SerializedName("height") val height: String = "",
    @field:SerializedName("mass") val mass: String = "",
    @field:SerializedName("hair_color") val hairColor: String = "",
    @field:SerializedName("skin_color") val skinColor: String = "",
    //TODO: add additional fields
) {
    @PrimaryKey(autoGenerate = true) var id: Int? = null
}
