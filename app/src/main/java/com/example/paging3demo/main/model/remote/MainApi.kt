package com.example.paging3demo.main.model.remote

import com.example.paging3demo.main.model.MainCommentsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MainApi {

    @GET("comments")
    suspend fun getComments(
        @Query("postId") page: Int
    ): Response<MainCommentsResponse>
}