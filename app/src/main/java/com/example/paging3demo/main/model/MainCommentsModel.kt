package com.example.paging3demo.main.model

sealed class MainCommentsModel {
    data class CommentsItem(val item: MainCommentsResponse.MainCommentsItem) :
        MainCommentsModel()

    data class SeparatorItem(val description: String) : MainCommentsModel()
}

val MainCommentsModel.CommentsItem.id: Int
    get() = this.item.id