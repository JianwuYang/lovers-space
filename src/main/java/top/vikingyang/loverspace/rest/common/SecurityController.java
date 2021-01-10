package top.vikingyang.loverspace.rest.common;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.vikingyang.loverspace.config.security.MyUserDetails;
import top.vikingyang.loverspace.entity.common.CommonResult;

@RestController
public class SecurityController {

    @RequestMapping("/rest/userInfo")
    public CommonResult<UserDetails> getUserInfo(@AuthenticationPrincipal MyUserDetails myUserDetails){
        CommonResult<UserDetails> result = new CommonResult<>();
        result.setData(myUserDetails);
        return result;
    }
}
