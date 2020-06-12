package gupt.cjh.noteblog.controller;

import gupt.cjh.noteblog.entity.CodeMsg;
import gupt.cjh.noteblog.entity.RespBean;
import gupt.cjh.noteblog.entity.User;
import gupt.cjh.noteblog.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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