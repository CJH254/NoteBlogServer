package gupt.cjh.noteblog.exception;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import gupt.cjh.noteblog.entity.CodeMsg;
import gupt.cjh.noteblog.entity.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

/**
 * @ClassName GlobalExceptionHandler
 * @Description: TODO
 * @Author 二维世界是个圆
 * @Date 2020/3/22
 * @Version V1.0
 **/
@RestControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(SQLException.class)
    public RespBean SQLException(Exception e) {
        if (e instanceof MySQLIntegrityConstraintViolationException) {
            return RespBean.error(CodeMsg.UNIQUE_INDEX);
        }
        return RespBean.error(CodeMsg.DATABASE_ERROR);
    }

}
