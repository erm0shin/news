insert into blogs(id,
                  title,
                  idempotent_key)
values (1,
        'blog1',
        'id_key_blog1');

insert into blogs(id,
                  title,
                  idempotent_key)
values (2,
        'blog2',
        'id_key_blog2');

insert into blogs(id,
                  title,
                  idempotent_key)
values (3,
        'blog3',
        'id_key_blog3');

---------------------------------

insert into authors(id,
                    name,
                    idempotent_key)
values (1,
        'author1',
        'id_key_author1');

insert into authors(id,
                    name,
                    idempotent_key)
values (2,
        'author2',
        'id_key_author2');

---------------------------------

insert into news(id,
                 title,
                 content,
                 image_url,
                 idempotent_key,
                 blog_id,
                 author_id)
values (1,
        'news_title1',
        'news_content1',
        'image_url1',
        'id_key_news1',
        1,
        1);

insert into news(id,
                 title,
                 content,
                 image_url,
                 idempotent_key,
                 blog_id,
                 author_id)
values (2,
        'news_title2',
        'news_content2',
        'image_url2',
        'id_key_news2',
        1,
        2);

insert into news(id,
                 title,
                 content,
                 image_url,
                 idempotent_key,
                 blog_id,
                 author_id)
values (3,
        'news_title3',
        'news_content3',
        'image_url3',
        'id_key_news3',
        2,
        1);