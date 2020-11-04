package top.vikingyang.loverspace.mapper.common;

import top.vikingyang.loverspace.entity.common.EveryDayImage;

public interface EveryDayImageMapper {

    int deleteByPrimaryKey(Long id);

    int insert(EveryDayImage record);

    int insertSelective(EveryDayImage record);

    EveryDayImage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(EveryDayImage record);

    int updateByPrimaryKeyWithBLOBs(EveryDayImage record);

    int updateByPrimaryKey(EveryDayImage record);
}