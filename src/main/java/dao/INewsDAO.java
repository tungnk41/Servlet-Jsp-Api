package dao;

import model.NewsModel;

import java.util.List;

public interface INewsDAO extends GenericDAO<NewsModel> {
    List<NewsModel> findByCategoryId(long categoryId);

}
