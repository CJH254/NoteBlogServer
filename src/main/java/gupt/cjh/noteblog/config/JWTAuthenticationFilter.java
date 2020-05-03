package gupt.cjh.noteblog.config;

/**
 * @ClassName JWTAuthenticationFilter
 * @Description: TODO
 * @Author 二维世界是个圆
 * @Date 2020/3/26
 * @Version V1.0
 **/

import com.fasterxml.jackson.databind.ObjectMapper;
import gupt.cjh.noteblog.pojo.CodeMsg;
import gupt.cjh.noteblog.pojo.RespBean;
import gupt.cjh.noteblog.pojo.User;
import gupt.cjh.noteblog.utils.TestJwtUtils;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

/**
 * 验证用户名密码正确后，生成一个token，并将token返回给客户端
 * 该类继承自UsernamePasswordAuthenticationFilter，重写了其中的2个方法 ,
 * attemptAuthentication：接收并解析用户凭证。
 * successfulAuthentication：用户成功登录后，这个方法会被调用，我们在这个方法里生成token并返回。
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        super.setFilterProcessesUrl("/doLogin");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        // 从输入流中获取到登录的信息
        try {
            User loginUser = new ObjectMapper().readValue(request.getInputStream(), User.class);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword())
            );
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 成功验证后调用的方法
    // 如果验证成功，就生成token并返回
    //TODO:存入redis，设置时间
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        User user = (User) authResult.getPrincipal();
        String role = "";
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        for (GrantedAuthority authority : authorities) {
            role = authority.getAuthority();
        }
        String token = TestJwtUtils.createToken(user.getUsername(), role);
        //String token = JwtTokenUtils.createToken(jwtUser.getUsername(), false);
        // 返回创建成功的token
        // 但是这里创建的token只是单纯的token
        // 按照jwt的规定，最后请求的时候应该是 `Bearer token`
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");

        String tokenStr = TestJwtUtils.TOKEN_PREFIX + token;
        response.setHeader("token", tokenStr);

        RespBean<User> ok = RespBean.ok(CodeMsg.SUCCESS, user);
        String s = new ObjectMapper().writeValueAsString(ok);
        response.getWriter().write(s);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest req, HttpServletResponse resp, AuthenticationException exception) throws IOException, ServletException {
        resp.setContentType("application/json;charset=utf-8");

        RespBean respBean = RespBean.error("登录失败！");
        if (exception instanceof LockedException) {
            respBean.setMsg("账户被锁定，请联系管理员!");
        } else if (exception instanceof CredentialsExpiredException) {
            respBean.setMsg("密码过期，请联系管理员！");
        } else if (exception instanceof AccountExpiredException) {
            respBean.setMsg("账户过期，请联系管理员！ ");
        } else if (exception instanceof DisabledException) {
            respBean.setMsg("账户被禁用，请联系管理员");
        } else if (exception instanceof BadCredentialsException) {
            respBean.setMsg("密码输入错误，请重新输入");
        } else if (exception instanceof InternalAuthenticationServiceException) {
            respBean.setMsg("用户名输入错误，请重新输入");
        }
        PrintWriter out = resp.getWriter();
        out.write(new ObjectMapper().writeValueAsString(respBean));
        out.flush();
        out.close();

    }
}