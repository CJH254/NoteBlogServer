package gupt.cjh.noteblog.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
@Data
@ToString
public class Tag implements Serializable {

    private static final long serialVersionUID = -2561405339130268507L;

    private Integer id;

    private String name;

}