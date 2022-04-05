package com.order.app;

import com.order.utils.Constants;
import com.order.utils.CookieUtils;
import com.order.utils.Passport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登录配置
 *
 */
@Configuration
public class WebSecurityConfig extends WebMvcConfigurerAdapter {

    /**
     * 登录session key
     */
    public final static String SESSION_KEY = "user";

    @Bean
    public SecurityInterceptor getSecurityInterceptor() {
        return new SecurityInterceptor();
    }

    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());

        // 排除配置
        addInterceptor.excludePathPatterns("/error");
        addInterceptor.excludePathPatterns("/login**");
        addInterceptor.excludePathPatterns("/user/login*");
        addInterceptor.excludePathPatterns("/user/sendCode*");
        addInterceptor.excludePathPatterns("/user/checkCode*");
        addInterceptor.excludePathPatterns("/user/register*");

        addInterceptor.excludePathPatterns("/trade/getTradeByTradeNumWeb");

        // 拦截配置
        addInterceptor.addPathPatterns("/**");
    }

    private class SecurityInterceptor extends HandlerInterceptorAdapter {

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
                throws Exception {
            //HttpSession session = request.getSession();
            Passport ppt_c = Passport.fromString(CookieUtils.getCookieValue(request, Constants.PASSPORT_COOKIE_NAME_C));
            Passport ppt_d = Passport.fromString(CookieUtils.getCookieValue(request, Constants.PASSPORT_COOKIE_NAME_D));
            if (ppt_c != null||ppt_d!=null)
                return true;
            System.out.println("===============未登录=================");
            // 跳转登录
            String url = "/login";
           // response.sendRedirect(url);
           // response.getOutputStream().print("{errorCode:1,errorMsg:'用户未登录'}");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            String jsonStr = "{\"errorCode\":\"-1\",\"errorMsg\":\"用户未登录\"}";
            PrintWriter out = null;
            try {
                out = response.getWriter();
                out.write(jsonStr);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (out != null) {
                    out.close();
                }
            }
            return false;
        }
    }
}