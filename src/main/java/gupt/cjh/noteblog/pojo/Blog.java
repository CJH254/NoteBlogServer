package gupt.cjh.noteblog.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Blog implements Serializable {

    private static final long serialVersionUID = 3140143855403698898L;

    private Integer id;

    private Integer uId;

    private String title;

    private String description;

    private String content;

    private Integer views;

    private Boolean status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date updateTime;

    private List<Tag> tags;

    public Blog( Integer uId,String title, String description, String content) {
        this.uId=uId;
        this.title = title;
        this.description = description;
        this.content = content;
    }

    public Blog( Integer id,Integer uId,String title, String description, String content) {
        this.id=id;
        this.uId=uId;
        this.title = title;
        this.description = description;
        this.content = content;
    }
}