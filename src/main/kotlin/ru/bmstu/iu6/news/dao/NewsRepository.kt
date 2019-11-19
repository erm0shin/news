package ru.bmstu.iu6.news.dao

import kotlinx.coroutines.flow.Flow
import org.springframework.data.r2dbc.core.DatabaseClient
import org.springframework.data.r2dbc.core.asType
import org.springframework.data.r2dbc.core.flow
import org.springframework.stereotype.Repository
import ru.bmstu.iu6.news.entites.Test


//public interface NewsRepository: ReactiveCrudRepository<Test, Long>

@Repository
public class NewsRepository(
        private val client: DatabaseClient
) {
    fun findAll(): Flow<Test> =
            client.select().from("test").asType<Test>().fetch().flow()


}
