package top.vikingyang.lovinglambs.service.admin.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.vikingyang.lovinglambs.entity.admin.User;
import top.vikingyang.lovinglambs.mapper.admin.UserMapper;
import top.vikingyang.lovinglambs.service.admin.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void create(User user) {
        userMapper.insertSelective(user);
    }

    @Override
    public void updateById(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User findByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }
}
