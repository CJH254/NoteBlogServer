package gupt.cjh.noteblog.pojo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @ClassName UserRole
 * @Description: TODO
 * @Author 二维世界是个圆
 * @Date 2020/3/26
 * @Version V1.0
 **/
@Data
@ToString
public class UserRole implements Serializable {

    private static final long serialVersionUID = -3319363887881403011L;

    private Integer id;

    private Integer userId;

    private Integer roleId;

}
