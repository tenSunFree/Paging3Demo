package com.example.paging3demo.main.viewModel

import androidx.lifecycle.ViewModel
import androidx.paging.*
import com.example.paging3demo.main.model.MainCommentsModel
import com.example.paging3demo.main.model.MainCommentsResponse
import com.example.paging3demo.main.model.id
import com.example.paging3demo.main.model.remote.MainRepository
import com.example.paging3demo.main.model.remote.MainPagingSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MainViewModel(private val repository: MainRepository) : ViewModel() {

    val getComments: Flow<PagingData<MainCommentsModel>> = getCommentsFlow()
        .map { pagingData ->
            pagingData.map { MainCommentsModel.CommentsItem(it) }
        }
        .map {
            it.insertSeparators<MainCommentsModel.CommentsItem, MainCommentsModel> { before, after ->
                if (after == null) return@insertSeparators MainCommentsModel.SeparatorItem(
                    "End of list"
                )
                if (before == null) return@insertSeparators MainCommentsModel.SeparatorItem(
                    "ID 1-10"
                )
                if (before.id < after.id) {
                    if (after.id % 10 == 1) {
                        MainCommentsModel.SeparatorItem(
                            "ID ${before.id + 1}-${before.id + 10}"
                        )
                    } else {
                        null
                    }
                } else {
                    null
                }
            }
        }


    private fun getCommentsFlow(): Flow<PagingData<MainCommentsResponse.MainCommentsItem>> {
        return Pager(PagingConfig(20)) {
            MainPagingSource(repository)
        }.flow
    }
}