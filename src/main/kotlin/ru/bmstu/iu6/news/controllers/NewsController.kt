package ru.bmstu.iu6.news.controllers

import kotlinx.coroutines.flow.Flow
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import ru.bmstu.iu6.news.entites.News
import ru.bmstu.iu6.news.services.NewService

@RestController
@RequestMapping("/api/v1/news")
public class NewsController(
        private val newService: NewService
) {

    // For tests
    @GetMapping(value = ["/"], produces = [MediaType.APPLICATION_STREAM_JSON_VALUE])
    fun getAllNews(): Flow<News> {
        return newService.getAllNews()
    }

    @GetMapping("/{id}")
    suspend fun getNews(@PathVariable id: Long): News? {
        return newService.getNewsById(id)
    }

    @PostMapping
    suspend fun createNews(@RequestBody news: News) {
        newService.insertNews(news)
    }

    @PutMapping("/")
    suspend fun editNews(@RequestBody news: News) {
        newService.updateNewsById(news)
    }

    @DeleteMapping("/{id}")
    suspend fun deleteNews(@PathVariable id: Long) {
        newService.deleteNewsById(id)
    }
}
