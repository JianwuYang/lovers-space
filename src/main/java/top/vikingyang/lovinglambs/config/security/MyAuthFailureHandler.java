package top.vikingyang.lovinglambs.config.security;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import top.vikingyang.lovinglambs.entity.common.CommonResult;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@Component
public class MyAuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        String msg = messageSource.getMessage(exception.getMessage(), null, Locale.CHINA);
        CommonResult<?> result = new CommonResult<>(0, msg);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(JSON.toJSONString(result));
        response.getWriter().flush();
    }

}
