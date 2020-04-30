package gupt.cjh.noteblog.service;

import gupt.cjh.noteblog.dao.UserMapper;
import gupt.cjh.noteblog.dao.UserRoleMapper;
import gupt.cjh.noteblog.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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
