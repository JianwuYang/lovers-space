package top.vikingyang.lovinglambs.mapper.lovers;

import top.vikingyang.lovinglambs.entity.lovers.MissingCombo;

public interface MissingComboMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MissingCombo record);

    int insertSelective(MissingCombo record);

    MissingCombo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MissingCombo record);

    int updateByPrimaryKey(MissingCombo record);

    MissingCombo findByLambId(Long lambId);
}