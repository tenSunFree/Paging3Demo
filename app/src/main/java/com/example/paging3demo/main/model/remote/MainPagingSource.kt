package com.example.paging3demo.main.model.remote

import androidx.paging.PagingSource
import com.example.paging3demo.main.model.MainCommentsResponse

class MainPagingSource(
    private val repository: MainRepository
) : PagingSource<Int, MainCommentsResponse.MainCommentsItem>() {

    override suspend fun load(params: LoadParams<Int>):
            LoadResult<Int, MainCommentsResponse.MainCommentsItem> {

        return try {
            val nextKey = params.key ?: 1
            val response = repository.getComments(nextKey)
            LoadResult.Page(
                data = response,
                prevKey = if (nextKey == 1) null else nextKey - 1,
                nextKey = if (nextKey > 15) null else nextKey + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
