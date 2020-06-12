package gupt.cjh.noteblog.dao;

import gupt.cjh.noteblog.entity.Role;
import gupt.cjh.noteblog.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 根据Username加载User
     * @param username
     * @return
     */
    User loadUserByUsername(String username);

    /**
     * 根据Id加载Role
     * @param id
     * @return
     */
    List<Role> getUserRolesById(Integer id);

}