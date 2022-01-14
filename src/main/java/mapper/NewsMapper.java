package mapper;

import model.NewsModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsMapper implements RowMapper<NewsModel>{
    @Override
    public NewsModel mapRow(ResultSet rs) {
        try {
            NewsModel news = new NewsModel();
            news.setId(rs.getLong("id"));
            news.setTitle(rs.getString("title"));
            news.setContent(rs.getString("content"));
            news.setCategoryId(rs.getLong("category_id"));
            news.setThumbnail(rs.getString("thumbnail"));
            news.setShortDescription(rs.getString("short_description"));
            news.setCreateDate(rs.getTimestamp("create_date"));
            news.setCreateBy(rs.getString("create_by"));
            if (rs.getTimestamp("modified_date") != null) {
                news.setModifiedDate(rs.getTimestamp("modified_date"));
            }
            if (rs.getString("modified_by") != null) {
                news.setModifiedBy(rs.getString("modified_by"));
            }
            return news;
        } catch (SQLException e) {
            return null;
        }
    }
}
