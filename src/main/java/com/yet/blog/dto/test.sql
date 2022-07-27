SELECT a.id,article_cover,article_title,SUBSTR( article_content, 1, 500 ) AS article_content,a.create_time,a.type,a.is_top,a.category_id,category_name,t.id AS tag_id,t.tag_name
FROM(SELECT id,article_cover,article_title,article_content,type,is_top,create_time,category_id FROM tb_article
    WHERE is_delete = 0 AND STATUS = 1 ORDER BY is_top DESC, id DESC LIMIT 0, 10 ) a
    JOIN tb_category c ON a.category_id = c.id
    JOIN tb_article_tag atg ON a.id = atg.article_id
    JOIN tb_tag t ON t.id = atg.tag_id
ORDER BY a.is_top DESC,a.id DESC