package gupt.cjh.noteblog.dao;

import gupt.cjh.noteblog.pojo.Tag;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagMapper {


    int insert(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Tag record);

    /**
     * 获取所有标签
     * @return
     */
    List<Tag> getAllTags();

    /**
     * 修改标签
     * @param record
     * @return
     */
    Integer updateTagSelective(Tag record);

    /**
     * 删除标签
     * @param id
     * @return
     */
    Integer deleteByPrimaryKey(Integer id);

    /**
     * 批量删除标签
     * @param tagIds
     * @return
     */
    Integer deleteBatchTags(@Param("tagIds") Integer[] tagIds);
}