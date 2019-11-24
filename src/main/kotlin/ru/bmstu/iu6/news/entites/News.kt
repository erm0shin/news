package ru.bmstu.iu6.news.entites

import org.springframework.data.annotation.Id

data class News(
        @Id val id: Long?,
        val title: String,
        val content: String,
        val imageUrl: String,
        val idempotentKey: String?,
        val blogId: Long,
        val authorId: Long
)