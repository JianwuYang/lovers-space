package top.vikingyang.loverspace.config.security;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import top.vikingyang.loverspace.entity.common.CommonResult;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

@Component
public class MyAuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setStatus(HttpStatus.OK.value());
        String msg = messageSource.getMessage("login_success", null, Locale.CHINA);
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("accessToken", "accessToken");
        CommonResult<?> result = new CommonResult<>(msg, data);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(JSON.toJSONString(result));
        response.getWriter().flush();
    }
}
