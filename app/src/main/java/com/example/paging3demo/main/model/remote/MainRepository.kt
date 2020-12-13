package com.example.paging3demo.main.model.remote

import com.example.paging3demo.common.model.Result
import com.example.paging3demo.main.model.MainCommentsResponse

class MainRepository(private val service: MainWebService) {

    suspend fun getComments(postId: Int): MainCommentsResponse {
        return when (val result = service.getComments(postId)) {
            is Result.Success -> result.data
            is Result.Error -> throw result.error
        }
    }
}