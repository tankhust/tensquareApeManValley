package com.tensquare.search.service;

import com.tensquare.search.dao.ArticleDao;
import com.tensquare.search.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

/**
 * @author tank
 * @create 2019/01/16 15:43
 */
@Service
public class ArticleService {
//    @Autowired
//    private IdWorker idWorker;

    @Autowired
    private ArticleDao articleDao;

    public void save(Article article) {
//        article.setId(idWorker.nextId()+"");
        articleDao.save(article);
    }

    public Page<Article> findByKey(String key, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return articleDao.findByTitleOrContentLike(key, key, pageable);

    }
}
