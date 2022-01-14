package dao.impl;

import dao.ICategoryDAO;
import mapper.CategoryMapper;
import model.CategoryModel;

import java.util.List;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {
    @Override
    public CategoryModel findById(Long id) {
        String sql = "SELECT * FROM category WHERE id = ?";
        List<CategoryModel> result = query(sql,new CategoryMapper(),id);
        if(result.size() > 1){
            System.out.println("Exist many entities have same id : " + result.toString());
            return null;
        }
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public List<CategoryModel> findByName(String name) {
        String sql = "SELECT * FROM category WHERE name = ?";
        return query(sql,new CategoryMapper(),name);
    }

    @Override
    public List<CategoryModel> findAll() {
        String sql = "SELECT * FROM category";
        return query(sql,new CategoryMapper());
    }


}
