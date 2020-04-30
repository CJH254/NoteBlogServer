package gupt.cjh.noteblog.dao;

import gupt.cjh.noteblog.pojo.Blog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BlogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Blog record);

    int insertSelective(Blog record);

    Blog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKey(Blog record);

    List<Blog> getAllBlogByPage(@Param("page") Integer page, @Param("size") Integer size);

    List<Blog> selectBlogById(@Param("page") Integer page, @Param("size") Integer size, @Param("blog") Blog blog);

    Integer deleteBatchBlog(@Param("BlogIds") Integer[] BlogIds);

    Long getTotal(@Param("blog") Blog blog);

}