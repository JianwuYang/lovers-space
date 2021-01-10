package top.vikingyang.lovinglambs.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.vikingyang.lovinglambs.entity.admin.User;
import top.vikingyang.lovinglambs.service.admin.UserService;

@Service
public class MyUserDetailsService implements UserDetailsService {


    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.findByUserName(s);
        if(user == null){
            throw new UsernameNotFoundException("user_not_found");
        }
        return new MyUserDetails(user);
    }
}
