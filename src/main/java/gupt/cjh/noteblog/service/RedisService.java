package gupt.cjh.noteblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @ClassName RedisService
 * @Description: TODO
 * @Author 二维世界是个圆
 * @Date 2020/5/2
 * @Version V1.0
 **/
@Component
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    public boolean set(final String key, Object value) {
        boolean result = false;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        operations.set(key, value);
        result = true;
        return result;
    }

    public Object get(final String key) {
        Object result = null;
        ValueOperations operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }

    public boolean exists(final String key){
        return redisTemplate.hasKey(key);
    }

    public boolean remove(final String key) {
        if (exists(key)){
            Boolean delete = redisTemplate.delete(key);
            return delete;
        }
        return false;
    }
}
