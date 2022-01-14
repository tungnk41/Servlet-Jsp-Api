package dao;

import model.CategoryModel;

import java.util.List;

public interface ICategoryDAO extends GenericDAO<CategoryModel> {
    CategoryModel findById(Long id);
    List<CategoryModel> findByName(String name);
    List<CategoryModel> findAll();
}
