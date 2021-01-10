package top.vikingyang.lovinglambs.mapper.lovers;

import top.vikingyang.lovinglambs.entity.lovers.Sheepfold;

public interface SheepfoldMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Sheepfold record);

    int insertSelective(Sheepfold record);

    Sheepfold selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Sheepfold record);

    int updateByPrimaryKey(Sheepfold record);
}