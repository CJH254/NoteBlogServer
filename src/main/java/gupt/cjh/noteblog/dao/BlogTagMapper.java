package gupt.cjh.noteblog.dao;

import gupt.cjh.noteblog.pojo.BlogTag;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogTagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogTag record);

    int insertSelective(BlogTag record);

    BlogTag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlogTag record);

    int updateByPrimaryKey(BlogTag record);

    Integer insertBlogTag(@Param("blogId") Integer blogId,@Param("tagIds") Integer[] tagIds);
    Integer deleteByBlogId(Integer blogId);
    Integer deleteBatchBlogWithTag(@Param("BlogIds") Integer[] BlogIds);
}