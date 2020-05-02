package gupt.cjh.noteblog.config;

import gupt.cjh.noteblog.utils.TestJwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName AutoIdempotentInterceptor
 * @Description: TODO
 * @Author 二维世界是个圆
 * @Date 2020/5/1
 * @Version V1.0
 **/
@Configuration
public class AutoIdempotentInterceptor implements HandlerInterceptor {

    @Autowired
    TestJwtUtils testJwtUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
