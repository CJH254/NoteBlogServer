package gupt.cjh.noteblog.controller;

import gupt.cjh.noteblog.entity.*;
import gupt.cjh.noteblog.service.Impl.BlogServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

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
        return RespBean.ok(CodeMsg.SUCCESS, blogById);
    }

    @PostMapping("/releaseBlog")
    public RespBean releaseBlog(@RequestBody FrontBlogTag ft) {
        Blog blog = new Blog
                (ft.getUId(), ft.getTitle(), ft.getDescription(), ft.getContent());
        Tag[] tags = ft.getTags();
        Integer[] integers = null;
        if (tags!=null&&tags.length!=0){
            integers = Arrays.stream(tags).map(ele -> ele.getId()).toArray(Integer[]::new);
        }
        return blogService.releaseBlog(blog, integers) ? RespBean.ok(CodeMsg.SUCCESS) : RespBean.error(CodeMsg.FAILED);
    }

    @PutMapping("/updateBlog")
    public RespBean updateBlog(@RequestBody FrontBlogTag ft) {
        Blog blog = new Blog
                (ft.getId(), ft.getUId(), ft.getTitle(), ft.getDescription(), ft.getContent());
        Tag[] tags = ft.getTags();
        Integer[] integers = null;
        if (tags!=null&&tags.length!=0){
            integers = Arrays.stream(tags).map(ele -> ele.getId()).toArray(Integer[]::new);
        }
        return blogService.updateBlog(blog, integers) ? RespBean.ok(CodeMsg.SUCCESS) : RespBean.error(CodeMsg.FAILED);
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
