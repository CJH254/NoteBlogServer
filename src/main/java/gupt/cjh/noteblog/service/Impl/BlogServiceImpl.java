package gupt.cjh.noteblog.service.Impl;

import gupt.cjh.noteblog.dao.BlogMapper;
import gupt.cjh.noteblog.dao.BlogTagMapper;
import gupt.cjh.noteblog.dao.TagMapper;
import gupt.cjh.noteblog.entity.Blog;
import gupt.cjh.noteblog.entity.RespPageBean;
import gupt.cjh.noteblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @ClassName BlogServiceImpl
 * @Description: TODO
 * @Author 二维世界是个圆
 * @Date 2020/4/28
 * @Version V1.0
 **/
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    TagMapper tagMapper;

    @Autowired
    BlogMapper blogMapper;

    @Autowired
    BlogTagMapper blogTagMapper;


    @Override
    public RespPageBean getBlogById(Integer page, Integer size, Blog blog) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Blog> blogList = blogMapper.selectBlogByUserId(page, size, blog);
        Long total = blogMapper.getTotal(blog);
        RespPageBean bean = new RespPageBean();
        bean.setData(blogList);
        bean.setTotal(total);
        return bean;
    }

    @Override
    public Blog getBlogDetail(Integer blogId) {
        Blog blog = blogMapper.getBlogDetail(blogId);
        return blog;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public Boolean updateBlog(Blog blog, Integer[] tagId) {
        boolean isUpdate = false;
        if (blog != null) {
            blog.setUpdateTime(new Date());
            isUpdate = blogMapper.updateByPrimaryKeySelective(blog) == 1;
            if (tagId != null && tagId.length != 0) {
                blogTagMapper.deleteByBlogId(blog.getId());
                isUpdate = blogTagMapper.insertBlogTag(blog.getId(), tagId) == tagId.length;
            }
        }
        return isUpdate;
    }

    @Override
    public Integer deleteBlog(Integer blogId) {
        blogTagMapper.deleteByBlogId(blogId);
        return blogMapper.deleteByPrimaryKey(blogId);
    }

    @Override
    public Integer deleteBatchBlog(Integer[] blogIds) {
        blogTagMapper.deleteBatchBlogWithTag(blogIds);
        return blogMapper.deleteBatchBlog(blogIds);
    }

    @Override
    public Long getTotal(Blog blog) {
        return blogMapper.getTotal(blog);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public Boolean releaseBlog(Blog blog, Integer[] tagId) {
        boolean isRelease = false;
        if (blog != null) {
            blog.setCreateTime(new Date());
            isRelease = blogMapper.insertSelective(blog) == 1;
            if (tagId != null && tagId.length != 0) {
                isRelease = blogTagMapper.insertBlogTag(blog.getId(), tagId) == tagId.length;
            }
        }
        return isRelease;
    }


}
