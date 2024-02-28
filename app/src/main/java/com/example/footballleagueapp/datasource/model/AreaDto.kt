package com.example.footballleagueapp.datasource.model

import com.example.footballleagueapp.repositry.model.Area
import com.google.gson.annotations.SerializedName


data class AreaDto(

    @field:SerializedName("code")
    val code: String? = null,

    @field:SerializedName("flag")
    val flag: Any? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: Int? = null
) {
    fun toArea(): Area {
        return Area(
            flag = flag.toString(),
            name = name,
            id = id,
            code = code
        )
    }
}