package gupt.cjh.noteblog.service.Impl;

import gupt.cjh.noteblog.dao.UserMapper;
import gupt.cjh.noteblog.dao.UserRoleMapper;
import gupt.cjh.noteblog.entity.User;
import gupt.cjh.noteblog.service.UserService;
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
 * @ClassName UserServiceImpl
 * @Description: TODO
 * @Author 二维世界是个圆
 * @Date 2020/4/28
 * @Version V1.0
 **/
@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRoleMapper userRoleMapper;

    BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //以用户名查询是否存在相应的用户
        User user =  userMapper.loadUserByUsername(username);
        if (user == null){
            //：TODO 无法捕捉到UsernameNotFoundException，做不到相应的相应
            throw new UsernameNotFoundException("查询不到此用户");
        }
        //存在的话就根据用户ID查询相应的角色，并赋值给用户
        user.setRoles(userMapper.getUserRolesById(user.getId()));
        return user;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.READ_COMMITTED)
    public Integer registerUser(User user){
        User userParam = new User
                (user.getNickname(),user.getUsername(),bCryptPasswordEncoder.encode(user.getPassword()),user.getAvatarUrl(),new Date());
        userMapper.insertSelective(userParam);
        return userRoleMapper.insertUserRole(userParam,1);
    }
}
