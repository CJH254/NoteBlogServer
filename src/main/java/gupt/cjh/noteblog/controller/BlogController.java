package gupt.cjh.noteblog.controller;

import gupt.cjh.noteblog.entity.*;
import gupt.cjh.noteblog.service.Impl.BlogServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "获取博客信息", notes = "分页获取博客信息及数量，可根据Blog的内容属性模糊搜索相应博客，以及对应的条目数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", defaultValue = "1", required = false),
            @ApiImplicitParam(name = "size", value = "页数", defaultValue = "10", required = false),
            @ApiImplicitParam(name = "blog", value = "Blog类属性", defaultValue = "内容", required = false),
    }
    )
    @GetMapping("/getBlogById")
    public RespBean getBlogById(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Blog blog) {
        RespPageBean blogById = blogService.getBlogById(page, size, blog);
        return blogById!=null?RespBean.ok(CodeMsg.SUCCESS, blogById):RespBean.error(CodeMsg.FAILED,null);
    }

    @GetMapping("/getBlogDetail/{id}")
    public RespBean getBlogDetail(@PathVariable("id") Integer blogId) {
        Blog blog = blogService.getBlogDetail(blogId);
        return blog!=null? RespBean.ok(CodeMsg.SUCCESS, blog):RespBean.error(CodeMsg.FAILED,null);
    }

    @PostMapping("/releaseBlog")
    public RespBean releaseBlog(@RequestBody FrontBlogTag fb) {
        List<Tag> tags = fb.getTags();
        Blog blog = new Blog
                (fb.getUId(), fb.getTitle(), fb.getDescription(), fb.getContent());
        Integer[] releaseIds = null;
        if (tags != null && tags.size() != 0) {
            releaseIds = tags.stream().map(ele -> ele.getId()).toArray(Integer[]::new);
        }
        return blogService.releaseBlog(blog, releaseIds) ? RespBean.ok(CodeMsg.SUCCESS) : RespBean.error(CodeMsg.FAILED);
    }

    @PutMapping("/updateBlog")
    public RespBean updateBlog(@RequestBody FrontBlogTag ft) {
        List<Tag> tags = ft.getTags();
        Blog blog = new Blog
                (ft.getTitle(), ft.getId(), ft.getDescription(), ft.getContent());
        Integer[] updateIds = null;
        if (tags != null && tags.size() != 0) {
            updateIds = tags.stream().map(ele -> ele.getId()).toArray(Integer[]::new);
        }
        return blogService.updateBlog(blog, updateIds) ? RespBean.ok(CodeMsg.SUCCESS) : RespBean.error(CodeMsg.FAILED);
    }

    @DeleteMapping("/deleteBlog/{id}")
    public RespBean deleteBlog(@PathVariable Integer id) {
        return blogService.deleteBlog(id) == 1
                ? RespBean.ok(CodeMsg.SUCCESS) : RespBean.error(CodeMsg.FAILED);
    }

    @DeleteMapping("/deleteBatchBlog")
    public RespBean deleteBatchBlog(Integer[] BlogIds) {
        return blogService.deleteBatchBlog(BlogIds) == BlogIds.length
                ? RespBean.ok(CodeMsg.SUCCESS) : RespBean.error(CodeMsg.FAILED);
    }
}
