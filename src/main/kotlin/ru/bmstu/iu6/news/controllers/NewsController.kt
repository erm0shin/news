package ru.bmstu.iu6.news.controllers

import kotlinx.coroutines.flow.Flow
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import ru.bmstu.iu6.news.dao.NewsRepository
import ru.bmstu.iu6.news.entites.Test

@RestController
public class NewsController(
        private val newsRepository: NewsRepository
) {

    @GetMapping
    fun test(): Flow<Test> {
        return newsRepository.findAll()
    }
}
