package gupt.cjh.noteblog.entity;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @ClassName RespPageBean
 * @Description: TODO
 * @Author 二维世界是个圆
 * @Date 2020/4/30
 * @Version V1.0
 **/
@Data
@ToString
public class RespPageBean {
    /**
     * 总共循环的记录
     */
    private Long total;

    /**
     * 查询的数据
     */
    private List<?> data;
}
