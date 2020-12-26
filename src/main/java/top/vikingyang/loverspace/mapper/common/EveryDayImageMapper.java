package top.vikingyang.loverspace.mapper.common;

import org.apache.ibatis.annotations.Param;
import top.vikingyang.loverspace.entity.common.EveryDayImage;

public interface EveryDayImageMapper {

    int deleteByPrimaryKey(Long id);

    int insert(EveryDayImage record);

    int insertSelective(EveryDayImage record);

    EveryDayImage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(EveryDayImage record);

    int updateByPrimaryKeyWithBLOBs(EveryDayImage record);

    int updateByPrimaryKey(EveryDayImage record);

    /**
     * 查询当日数据
     * @param today 当天日期
     * @return 结果
     */
    EveryDayImage findTodayRecord(@Param("today") String today);
}