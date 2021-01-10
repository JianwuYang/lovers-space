package top.vikingyang.loverspace.mapper.lovers;

import top.vikingyang.loverspace.entity.lovers.Sheepfold;

public interface SheepfoldMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Sheepfold record);

    int insertSelective(Sheepfold record);

    Sheepfold selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Sheepfold record);

    int updateByPrimaryKey(Sheepfold record);
}