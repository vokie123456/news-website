package com.lxwtest.dao;

import com.lxwtest.model.News;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
//dao层是接口类型

@Mapper
public interface NewsDAO{
    String TABLE_NAME= "news";
    String INSERT_FIELDS=" title, link, image, like_count, comment_count, created_date, user_id"; //前面加空格，组合语句方便些
    String SELECT_FIELDS= " id, "+INSERT_FIELDS;

    @Insert({"insert into ",TABLE_NAME,"(", INSERT_FIELDS, ") values (#{title},#{link},#{image},#{likeCount},#{commentCount},#{createdDate},#{userId})"})
    int addNews(News news);

    List<News> selectByUserIdAndOffset(@Param("userId") int userId, @Param("offset") int offset,
                                       @Param("limit") int limit);
}