package gupt.cjh.noteblog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
@Data
@ToString
public class Comment implements Serializable {

    private static final long serialVersionUID = 8727185107881507903L;

    private Integer id;

    private Integer uid;

    private String replyUid;

    private Integer blogId;

    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date createTime;

}