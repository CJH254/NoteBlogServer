package gupt.cjh.noteblog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @ClassName FrontBlogTag
 * @Description: TODO
 * @Author 二维世界是个圆
 * @Date 2020/4/26
 * @Version V1.0
 **/
@Data
@ToString
@AllArgsConstructor

public class FrontBlogTag {
    private Integer id;
    private Integer uId;
    private String title;

    private String description;

    private String content;
    private Tag[] tags;
}
