package top.vikingyang.loverspace.mapper.lovers;

import top.vikingyang.loverspace.entity.lovers.MissingCombo;

public interface MissingComboMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MissingCombo record);

    int insertSelective(MissingCombo record);

    MissingCombo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MissingCombo record);

    int updateByPrimaryKey(MissingCombo record);

    MissingCombo findByLambId(Long lambId);
}