package ru.bmstu.iu6.news.services

import org.springframework.stereotype.Service
import ru.bmstu.iu6.news.dao.NewsRepository
import ru.bmstu.iu6.news.entites.News

@Service
public class NewService(
        private val newsRepository: NewsRepository
) {
    public fun getAllNews() =
            newsRepository.findAll()

    public suspend fun getNewsById(id: Long) =
            newsRepository.findOne(id)

    public suspend fun insertNews(news: News) =
            newsRepository.save(news)

    public suspend fun updateNewsById(news: News) =
            newsRepository.updateOne(news)


    public suspend fun deleteNewsById(id: Long) =
            newsRepository.deleteOne(id)

}