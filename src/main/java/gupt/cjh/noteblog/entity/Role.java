package gupt.cjh.noteblog.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class Role implements Serializable {

    private static final long serialVersionUID = 9009864152205517336L;

    private Integer id;

    private String name;

    private String namezh;

}