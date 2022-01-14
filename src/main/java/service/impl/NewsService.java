package service.impl;

import model.NewsModel;
import service.INewsService;

import java.util.List;

public class NewsService implements INewsService {
    @Override
    public List<NewsModel> findByCategoryId(Long categoryId) {
        return null;
    }

    @Override
    public NewsModel save(NewsModel newsModel) {
        return null;
    }

    @Override
    public NewsModel update(NewsModel newsModel) {
        return null;
    }

    @Override
    public int delete(long[] ids) {
        return 0;
    }

    @Override
    public List<NewsModel> findAll() {
        return null;
    }

    @Override
    public NewsModel find(long id) {
        return null;
    }
}
