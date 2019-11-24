# News Service

Сервис для выборки, создания, изменения и удаления новостей

## Getting Started

В данной инструкции описаны шаги по поднятию новостного сервиса, а также приведены примеры HTTP запросов и ответов

### Запуск сервиса

Перейти в корень приложения

Для поднятия PostgreSQL на локальной машине следует выполнить следующую команду
```
docker-compose up
```

Для запуска сервиса и наката миграций БД следует выполнить следующую команду
```
./gradlew bootRun -PspringProfile=local
```

После поднятия сервиса документация будет доступна по адресу
```
http://localhost:8080/swagger-ui.html#
```

### Примеры запросов и ответов

* Получение списка всех новостей

Запрос
```
curl http://localhost:8080/api/v1/news/
```
Ответ
```
{"id":1,"title":"news_title1","content":"news_content1","imageUrl":"image_url1","idempotentKey":"id_key_news1","blogId":1,"authorId":1}
{"id":2,"title":"news_title2","content":"news_content2","imageUrl":"image_url2","idempotentKey":"id_key_news2","blogId":1,"authorId":2}
{"id":3,"title":"news_title3","content":"news_content3","imageUrl":"image_url3","idempotentKey":"id_key_news3","blogId":2,"authorId":1}
```

* Получение одной новости
```
curl http://localhost:8080/api/v1/news/1

```
Ответ
```
{"id":1,"title":"news_title1","content":"news_content1","imageUrl":"image_url1","idempotentKey":"id_key_news1","blogId":1,"authorId":1}
```

* Создание новости
```
curl -X POST -H "Content-Type: application/json" -d '{"title":"testTitle","content":"testContent","imageUrl":"testImageUrl","authorId":1,"blogId":1,"idempotentKey":"testKey"}' http://localhost:8080/api/v1/news/
```
Тело ответа отсутствует

* Изменение новости
```
curl -X PUT -H "Content-Type: application/json" -d '{"id":12,"title":"testTitle","content":"testContent","imageUrl":"testImageUrl","authorId":1,"blogId":1}' http://localhost:8080/api/v1/news/
```
Тело ответа отсутствует

* Удаление новости
```
curl -X DELETE http://localhost:8080/api/v1/news/15  
```
Тело ответа отсутствует