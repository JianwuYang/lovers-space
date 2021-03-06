package top.vikingyang.lovinglambs.rest.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.Locale;

public class BaseController {

    @Autowired
    private MessageSource messageSource;

    protected String getMessage(String msg, Object[] params){
        return messageSource.getMessage(msg, params, Locale.CHINA);
    }
    protected String getMessage(String msg){
        return messageSource.getMessage(msg, null, Locale.CHINA);
    }
}
