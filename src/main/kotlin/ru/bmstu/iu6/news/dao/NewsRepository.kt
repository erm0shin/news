package ru.bmstu.iu6.news.dao

import kotlinx.coroutines.flow.Flow
import org.springframework.data.r2dbc.core.*
import org.springframework.stereotype.Repository
import ru.bmstu.iu6.news.entites.News


@Repository
public class NewsRepository(
        private val client: DatabaseClient
) {
    fun findAll(): Flow<News> =
            client.select().from("news").asType<News>().fetch().flow()

    suspend fun findOne(id: Long): News? =
            client.execute("SELECT * FROM news WHERE id = :id")
                    .bind("id", id)
                    .asType<News>()
                    .fetch()
                    .awaitOneOrNull()


    suspend fun updateOne(news: News) =
            client.execute("""
                UPDATE news SET 
                    title = :title,
                    content = :content,
                    image_url = :imageUrl,
                    blog_id = :blogId,
                    author_id = :authorId 
                WHERE
                    id = :id
                    """)
                    .bind("title", news.title)
                    .bind("content", news.content)
                    .bind("imageUrl", news.imageUrl)
                    .bind("blogId", news.blogId)
                    .bind("authorId", news.authorId)
                    .bind("id", news.id ?: -1)
                    .await()

    suspend fun save(news: News) {
        return client.execute("""
                insert into news(
                    id,
                    title,
                    content,
                    image_url,
                    idempotent_key,
                    blog_id,
                    author_id
                ) values (
                    nextval('news_sequence'),
                    :title,
                    :content,
                    :imageUrl,
                    :idempotentKey,
                    :blogId,
                    :authorId
                 )
                 """)
                .bind("title", news.title)
                .bind("content", news.content)
                .bind("imageUrl", news.imageUrl)
                .bind("idempotentKey", news.idempotentKey ?: "")
                .bind("blogId", news.blogId)
                .bind("authorId", news.authorId)
                .await()
    }

    suspend fun deleteOne(id: Long) =
            client.execute("DELETE FROM news WHERE id = :id")
                    .bind("id", id)
                    .await()

}
