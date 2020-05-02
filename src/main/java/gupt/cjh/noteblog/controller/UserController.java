package gupt.cjh.noteblog.controller;

import com.sun.org.apache.xpath.internal.SourceTree;
import gupt.cjh.noteblog.pojo.Blog;
import gupt.cjh.noteblog.pojo.CodeMsg;
import gupt.cjh.noteblog.pojo.RespBean;
import gupt.cjh.noteblog.pojo.User;
import gupt.cjh.noteblog.service.Impl.UserServiceImpl;
import gupt.cjh.noteblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.java2d.pipe.SpanIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName AuthController
 * @Description: TODO
 * @Author 二维世界是个圆
 * @Date 2020/3/24
 * @Version V1.0
 **/

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/register")
    public RespBean registerUser(@RequestBody User user) {
        if (userService.registerUser(user) == 1) {
            return RespBean.ok(CodeMsg.SUCCESS);
        }
        return RespBean.error(CodeMsg.REGISTER_FAILED);
    }

    //TODO: 注销登录写在前端 removeItem("Authorization")



}