package gupt.cjh.noteblog.controller;

import gupt.cjh.noteblog.entity.CodeMsg;
import gupt.cjh.noteblog.entity.RespBean;
import gupt.cjh.noteblog.entity.Tag;
import gupt.cjh.noteblog.service.Impl.TagServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName TagController
 * @Description: TODO
 * @Author 二维世界是个圆
 * @Date 2020/4/26
 * @Version V1.0
 **/
@RestController
@RequestMapping("/tag")
@Api(value = "标签信息管理")
public class TagController {

    @Autowired
    TagServiceImpl tagService;

    @GetMapping("/getAllTags")
    public RespBean getAllTags() {
        List<Tag> allTags = tagService.getAllTags();
        return RespBean.ok(CodeMsg.SUCCESS, allTags);
    }

    @PostMapping("/insertTag")
    public RespBean insertTag(@RequestBody Tag tag) {
        if (tagService.insertTag(tag) == 1) {
            return RespBean.ok(CodeMsg.SUCCESS);
        }
        return RespBean.error(CodeMsg.FAILED);
    }

    @DeleteMapping("/deleteTags/{id}")
    public RespBean deleteTags(@PathVariable Integer id) {
        if (tagService.deleteTags(id) == 1) {
            return RespBean.ok(CodeMsg.SUCCESS);
        }
        return RespBean.error(CodeMsg.DELETE_FAILED);
    }

    @PutMapping("/updateTags")
    public RespBean updateTags(@RequestBody Tag tag) {
        if (tagService.updateTags(tag) == 1) {
            return RespBean.ok(CodeMsg.SUCCESS);
        }
        return RespBean.error(CodeMsg.UPDATE_FAILED);
    }

    @DeleteMapping("/deleteBatchTags")
    public RespBean deleteBatchTags(Integer[] tagIds) {
        if (tagService.deleteBatchTags(tagIds) == tagIds.length) {
            return RespBean.ok(CodeMsg.SUCCESS);
        }
        return RespBean.error(CodeMsg.UPDATE_FAILED);
    }


}
