package com.sifatsdroid.practice

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Photo (
    @Expose
    @SerializedName("albumID")
    val albumID: Int,

    @Expose
    @SerializedName("id")
    val id: Int,
    @Expose
    @SerializedName("title")
    val title: String,
    @Expose
    @SerializedName("url")
    val url: String,
    @Expose
    @SerializedName("thumbNailUrl")
    val thumbNailUrl: String
)