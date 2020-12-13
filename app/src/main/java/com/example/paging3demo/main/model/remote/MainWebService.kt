package com.example.paging3demo.main.model.remote

import com.example.paging3demo.common.model.Result
import com.example.paging3demo.common.remote.BaseService
import com.example.paging3demo.main.model.MainCommentsResponse

class MainWebService(private val mainApi: MainApi) : BaseService() {

    suspend fun getComments(postId: Int): Result<MainCommentsResponse> {
        return createCall { mainApi.getComments(postId) }
    }
}