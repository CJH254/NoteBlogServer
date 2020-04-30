package gupt.cjh.noteblog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.omg.CORBA.INTERNAL;
import org.omg.PortableInterceptor.INACTIVE;

import java.io.Serializable;
@Data
@ToString
@AllArgsConstructor
public class BlogTag implements Serializable {

    private static final long serialVersionUID = 5230341320399131650L;

    private Integer id;

    private Integer blogId;

    private Integer tagId;

    public BlogTag(Integer blogId, Integer tagId) {
        this.blogId = blogId;
        this.tagId = tagId;
    }
}