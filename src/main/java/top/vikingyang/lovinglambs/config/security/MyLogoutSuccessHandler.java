package top.vikingyang.lovinglambs.config.security;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;
import top.vikingyang.lovinglambs.entity.common.CommonResult;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@Component
public class MyLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setStatus(HttpStatus.OK.value());
        String msg = messageSource.getMessage("logout_success", null, Locale.CHINA);
        CommonResult<?> result = new CommonResult<>(msg);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(JSON.toJSONString(result));
        response.getWriter().flush();
    }
}
