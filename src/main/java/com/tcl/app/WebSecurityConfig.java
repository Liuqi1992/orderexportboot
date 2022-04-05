package com.tcl.app;

import com.tcl.utils.Constants;
import com.tcl.utils.CookieUtils;
import com.tcl.utils.Passport;
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

        addInterceptor.excludePathPatterns("/doctor/login*");
        addInterceptor.excludePathPatterns("/doctor/getTradeAll");
        addInterceptor.excludePathPatterns("/doctor/checkCode*");
        addInterceptor.excludePathPatterns("/doctor/sendCode*");
        addInterceptor.excludePathPatterns("/doctor/register*");


        addInterceptor.excludePathPatterns("/doctor/getTradeByStatus");
        addInterceptor.excludePathPatterns("/trade/updateTradeStatus");
        addInterceptor.excludePathPatterns("/trade/updateTradeStatus2");

        addInterceptor.excludePathPatterns("/fileUpload");
        //找回密码
        addInterceptor.excludePathPatterns("/doctor/findDoctorByUserName");
        addInterceptor.excludePathPatterns("/doctor/sendCodeForget");
        addInterceptor.excludePathPatterns("/doctor/checkCodeForget");
        addInterceptor.excludePathPatterns("/doctor/updatePassword");

        addInterceptor.excludePathPatterns("/user/findUserByUserName");
        addInterceptor.excludePathPatterns("/user/sendCodeForget");
        addInterceptor.excludePathPatterns("/user/checkCodeForget");
        addInterceptor.excludePathPatterns("/user/updatePassword");

        addInterceptor.excludePathPatterns("/package/list_h");
        addInterceptor.excludePathPatterns("/newspaper/getNewspaper");
        addInterceptor.excludePathPatterns("/package/list");
        addInterceptor.excludePathPatterns("/package/search");
        addInterceptor.excludePathPatterns("/package/findOne");

        addInterceptor.excludePathPatterns("/reports/unscrambleReport");

        addInterceptor.excludePathPatterns("/package/packageDetail");
        addInterceptor.excludePathPatterns("/base/getBaseData");
        addInterceptor.excludePathPatterns("/hospital/listAll");

        addInterceptor.excludePathPatterns("/alipay/alipayBack.do");

        addInterceptor.excludePathPatterns("/dept/listall");
        // 采集手册 知识库
        addInterceptor.excludePathPatterns("/collectManual/getCollectManualByPId");
        addInterceptor.excludePathPatterns("/knowledge/getKnowledgeByPId");
        addInterceptor.excludePathPatterns("/knowledgedetails/getKnowledgedetailsByDId");

        //机构注册
        addInterceptor.excludePathPatterns("/institution/register");

        addInterceptor.excludePathPatterns("/doctor/reqDoctor");

        //套餐列表查询
        addInterceptor.excludePathPatterns("/package/search2");
        //套餐类型获取
        addInterceptor.excludePathPatterns("/texttype/getListByType");
        //检验商城
        addInterceptor.excludePathPatterns("/package/checkShopOfUser");
        //微信支付通知
        addInterceptor.excludePathPatterns("/wxpay/wxpayBack.do");
        //支付宝支付通知
        addInterceptor.excludePathPatterns("/alipay/alipayBack.do");

        //获取省市区县
        addInterceptor.excludePathPatterns("/province/provinceList");
        addInterceptor.excludePathPatterns("/city/getCityByProvinceId");
        addInterceptor.excludePathPatterns("/area/getAreaByCityId");

        addInterceptor.excludePathPatterns("/hospital/listByParam");

        addInterceptor.excludePathPatterns("/hospital/getHospitalByName");

        addInterceptor.excludePathPatterns("/version/getAppVersion");

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