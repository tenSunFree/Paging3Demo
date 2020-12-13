package com.example.paging3demo.main.model

import com.google.gson.annotations.SerializedName

class MainCommentsResponse : ArrayList<MainCommentsResponse.MainCommentsItem>() {
    data class MainCommentsItem(
        @SerializedName("body")
        val body: String,
        @SerializedName("email")
        val email: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("postId")
        val postId: Int
    )
}