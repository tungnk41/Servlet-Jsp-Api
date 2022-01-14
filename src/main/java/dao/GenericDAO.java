package dao;

import mapper.RowMapper;

import java.util.List;

public interface GenericDAO<T> {
    <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
    Long insert(String sql, Object... parameters);
    void update(String sql, Object... parameters);
    Boolean delete(String sql, Object... parameters);
    Integer count(String sql,Object... parameters);
}
