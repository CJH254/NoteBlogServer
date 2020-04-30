package gupt.cjh.noteblog.dao;

import gupt.cjh.noteblog.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleMapper {

    /**
     * 添加用户角色
     * @param user
     * @param roleId
     * @return
     */
    Integer insertUserRole(User user, @Param("roleId") Integer roleId);

}