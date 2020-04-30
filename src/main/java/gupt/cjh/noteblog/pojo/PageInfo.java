package gupt.cjh.noteblog.pojo;

import lombok.Data;

import java.util.List;

/**
 * @ClassName PageInfo
 * @Description: TODO
 * @Author 二维世界是个圆
 * @Date 2020/3/27
 * @Version V1.0
 **/

@Data
public class PageInfo<T> {

    /**
     * 当前页
     */
    private int pageNum;
    /**
     * 每页的数量
     */
    private int pageSize;
    /**
     * 总页数
     */
    private int pages;
    /**
     * 总记录数
     */
    private long total;
    /**
     * 结果集
     */
    private List<T> list;

    public PageInfo(PageInfo<T> pageInfo) {
        this.pageNum = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
        this.pages = pageInfo.getPages();
        this.total = pageInfo.getTotal();
        this.list = pageInfo.getList();
    }
}