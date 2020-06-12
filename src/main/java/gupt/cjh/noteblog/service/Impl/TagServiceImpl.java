package gupt.cjh.noteblog.service.Impl;

import gupt.cjh.noteblog.dao.TagMapper;
import gupt.cjh.noteblog.entity.Tag;
import gupt.cjh.noteblog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName TagServiceImpl
 * @Description: TODO
 * @Author 二维世界是个圆
 * @Date 2020/4/28
 * @Version V1.0
 **/
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagMapper tagMapper;

    @Override
    public List<Tag> getAllTags(){
        return tagMapper.getAllTags();
    }

    @Override
    public Integer insertTag(Tag tag){
        return tagMapper.insertSelective(tag);
    }

    @Override
    public Integer deleteTags(Integer tagId){
        return tagMapper.deleteByPrimaryKey(tagId);
    }

    @Override
    public Integer updateTags(Tag tag){
        return tagMapper.updateTagSelective(tag);
    }

    @Override
    public Integer deleteBatchTags(Integer[] tagIds) {
        return tagMapper.deleteBatchTags(tagIds);
    }
}
