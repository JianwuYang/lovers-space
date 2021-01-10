package top.vikingyang.lovinglambs.mapper.admin;

import top.vikingyang.lovinglambs.entity.admin.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User findByUserName(String userName);
}