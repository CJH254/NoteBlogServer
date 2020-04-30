package gupt.cjh.noteblog.service;

import gupt.cjh.noteblog.dao.TagMapper;
import gupt.cjh.noteblog.pojo.Tag;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName TagService
 * @Description: TODO
 * @Author 二维世界是个圆
 * @Date 2020/4/26
 * @Version V1.0
 **/
public interface TagService {

    /**
     * 获取所有标签
     *
     * @return
     */
    List<Tag> getAllTags();

    /**
     * 新增标签
     *
     * @param tag
     * @return
     */
    Integer insertTag(Tag tag);

    /**
     * 删除用户标签
     *
     * @param tagId
     * @return
     */
    Integer deleteTags(Integer tagId);

    /**
     * 修改用户标签
     *
     * @param tag
     * @return
     */
    Integer updateTags(Tag tag);

    /**
     * 批量删除标签
     * @param tagIds
     * @return
     */
    Integer deleteBatchTags(Integer[] tagIds);
}
