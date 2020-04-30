package gupt.cjh.noteblog.controller;

import gupt.cjh.noteblog.dao.BlogMapper;
import gupt.cjh.noteblog.pojo.*;
import gupt.cjh.noteblog.service.BlogService;
import gupt.cjh.noteblog.service.Impl.BlogServiceImpl;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @ClassName BlogService
 * @Description: TODO
 * @Author 二维世界是个圆
 * @Date 2020/3/28
 * @Version V1.0
 **/
@RestController
public class BlogController {

    @Autowired
    BlogServiceImpl blogService;

    @GetMapping("/getAllBlogByPage")
    public RespPageBean getAllBlogByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size,Blog blog) {
        return blogService.getAllBlogByPage(page,size,blog);
    }

    @GetMapping("/getBlogById")
    public RespPageBean getBlogById(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Blog blog) {
        return blogService.getBlogById(page,size,blog);
    }

    @PostMapping("/releaseBlog")
    public RespBean releaseBlog(@RequestBody FrontBlogTag frontBlogTag) {
        Blog blog = new Blog
                (frontBlogTag.getUId(), frontBlogTag.getTitle(), frontBlogTag.getDescription(), frontBlogTag.getContent());
        Tag[] tags1 = frontBlogTag.getTags();
        Integer[] tags = new Integer[tags1.length];
        for (int i = 0; i < tags1.length; i++) {
            tags[i] = tags1[i].getId();
        }
        if (blogService.releaseBlog(blog, tags)) {
            return RespBean.ok(CodeMsg.SUCCESS);
        }
        return RespBean.error(CodeMsg.FAILED);
    }

    @PutMapping("/updateBlog")
    public RespBean updateBlog(@RequestBody FrontBlogTag frontBlogTag) {
        //1.获取需要修改的信息
        Blog blog = new Blog
                (frontBlogTag.getId(), frontBlogTag.getUId(), frontBlogTag.getTitle(), frontBlogTag.getDescription(), frontBlogTag.getContent());
        Tag[] tags1 = frontBlogTag.getTags();
        Integer[] tags = new Integer[tags1.length];
        for (int i = 0; i < tags1.length; i++) {
            tags[i] = tags1[i].getId();
        }
        if (blogService.updateBlog(blog, tags)) {
            return RespBean.ok(CodeMsg.SUCCESS);
        }
        //2.需要修改的tag = >  获取修改了的blog的id,再去中间表修改关系
        return RespBean.error(CodeMsg.FAILED);
    }

    @DeleteMapping("/deleteBlog/{id}")
    public RespBean deleteBlog(@PathVariable Integer id) {
        if (blogService.deleteBlog(id) == 1) {
            return RespBean.ok(CodeMsg.SUCCESS);
        }
        return RespBean.error(CodeMsg.FAILED);
    }

    @DeleteMapping("/deleteBatchBlog")
    public RespBean deleteBatchBlog(Integer[] BlogIds) {
        if (blogService.deleteBatchBlog(BlogIds) == BlogIds.length) {
            return RespBean.ok(CodeMsg.SUCCESS);
        }
        return RespBean.error(CodeMsg.FAILED);
    }
}
