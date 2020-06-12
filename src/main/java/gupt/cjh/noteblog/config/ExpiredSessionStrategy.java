package gupt.cjh.noteblog.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import gupt.cjh.noteblog.entity.CodeMsg;
import gupt.cjh.noteblog.entity.RespBean;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @ClassName ExpiredSessionStrategy
 * @Description: TODO
 * @Author 二维世界是个圆
 * @Date 2020/3/28
 * @Version V1.0
 **/

/**
 * 用户重复登录响应
 */
public class ExpiredSessionStrategy implements SessionInformationExpiredStrategy {

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent sessionInformationExpiredEvent) throws IOException, ServletException {
        sessionInformationExpiredEvent.getResponse().setContentType("application/json;charset=UTF-8");
        sessionInformationExpiredEvent.getResponse().getWriter().write(objectMapper.writeValueAsString(new RespBean(CodeMsg.SESSION_REPEAT)));
    }
}
