package top.vikingyang.loverspace.service.admin;

import top.vikingyang.loverspace.entity.admin.User;

public interface UserService {

    User findById(Long id);

    void create(User user);

    void updateById(User user);

    User findByUserName(String userName);

}
