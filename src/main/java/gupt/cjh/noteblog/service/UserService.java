package gupt.cjh.noteblog.service;

import gupt.cjh.noteblog.entity.User;

/**
 * @ClassName UserService
 * @Description: TODO
 * @Author 二维世界是个圆
 * @Date 2020/3/16
 * @Version V1.0
 **/
public interface UserService {


    /**
     * 注册用户
     *
     * @param user 用户信息
     * @return
     */
    Integer registerUser(User user);
}
