package top.vikingyang.loverspace.mapper.lovers;

import top.vikingyang.loverspace.entity.lovers.Relationship;

public interface RelationshipMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Relationship record);

    int insertSelective(Relationship record);

    Relationship selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Relationship record);

    int updateByPrimaryKey(Relationship record);
}