package gupt.cjh.noteblog.service;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName TokenService
 * @Description: TODO
 * @Author 二维世界是个圆
 * @Date 2020/5/2
 * @Version V1.0
 **/

public interface TokenService {
    public String createToken();
    public boolean checkToken(HttpServletRequest request) throws Exception;
}
