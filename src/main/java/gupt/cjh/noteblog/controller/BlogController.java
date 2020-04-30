package gupt.cjh.noteblog.controller;

import gupt.cjh.noteblog.dao.BlogMapper;
import gupt.cjh.noteblog.pojo.*;
import gupt.cjh.noteblog.service.BlogService;
import gupt.cjh.noteblog.service.Impl.BlogServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/blog")
@Api(value = "博客信息管理")
public class BlogController {

    @Autowired
    BlogServiceImpl blogService;

    @ApiOperation(value = "获取博客信息",notes = "分页获取博客信息及数量，可根据Blog的内容属性模糊搜索相应博客，以及对应的条目数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", defaultValue = "1",required = false),
            @ApiImplicitParam(name = "size", value = "页数", defaultValue = "10",required = false),
            @ApiImplicitParam(name = "blog", value = "Blog类属性", defaultValue = "内容",required = false),
    }
    )
    @GetMapping("/getBlogById")
    public RespBean getBlogById(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Blog blog) {
        RespPageBean blogById = blogService.getBlogById(page, size, blog);
        return RespBean.ok(CodeMsg.SUCCESS,blogById);
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
