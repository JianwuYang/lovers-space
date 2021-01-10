package top.vikingyang.loverspace.mapper.lovers;

import top.vikingyang.loverspace.entity.lovers.Lamb;

public interface LambsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Lamb record);

    int insertSelective(Lamb record);

    Lamb selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Lamb record);

    int updateByPrimaryKey(Lamb record);
}