package service;

import model.NewsModel;

import java.util.List;

public interface INewsService {
    List<NewsModel> findByCategoryId(Long categoryId);
    NewsModel save(NewsModel newsModel);
    NewsModel update(NewsModel newsModel);
    int delete(long[] ids);
    List<NewsModel> findAll();
    NewsModel find(long id);
}
