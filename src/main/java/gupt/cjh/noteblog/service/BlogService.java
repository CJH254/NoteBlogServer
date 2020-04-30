package gupt.cjh.noteblog.service;

import gupt.cjh.noteblog.pojo.Blog;
import gupt.cjh.noteblog.pojo.RespPageBean;

import java.util.List;

/**
 * @ClassName BlogService
 * @Description: TODO
 * @Author 二维世界是个圆
 * @Date 2020/3/28
 * @Version V1.0
 **/

public interface BlogService {


    /**
     * 发布博客
     *
     * @param blog  博客内容
     * @param tagId 标签ID
     * @return
     */
    Boolean releaseBlog(Blog blog, Integer[] tagId);

    /**
     * 分页获取单用户博客
     *
     * @param page
     * @param size
     * @param blog
     * @return
     */
    RespPageBean getBlogById(Integer page, Integer size, Blog blog);

    /**
     * 修改用户博客
     *
     * @param blog
     * @param tagId
     * @return
     */
    Boolean updateBlog(Blog blog, Integer[] tagId);

    /**
     * 删除用户博客
     *
     * @param blogId
     * @return
     */
    Integer deleteBlog(Integer blogId);

    /**
     * 批量删除博客
     *
     * @param blogIds
     * @return
     */
    Integer deleteBatchBlog(Integer[] blogIds);

    /**
     * 获取博客数量
     * @param blog
     * @return
     */
    Long getTotal(Blog blog);

}
