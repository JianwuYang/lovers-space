package top.vikingyang.loverspace.service.common;

import org.apache.ibatis.annotations.Param;
import top.vikingyang.loverspace.entity.common.EveryDayImage;

public interface EveryDayImageService {

    int deleteByPrimaryKey(Long id);

    int insert(EveryDayImage record);

    int insertSelective(EveryDayImage record);

    EveryDayImage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(EveryDayImage record);

    int updateByPrimaryKeyWithBLOBs(EveryDayImage record);

    int updateByPrimaryKey(EveryDayImage record);

    /**
     * 对外暴露借口每日图片下载
     *
     * @return 结果
     */
    public EveryDayImage downloadTodayImage();

    /**
     * 检查是否已经存在当日的图片数据
     *
     * @return 是/否
     */
    public boolean checkHasTodayImage();

    /**
     * 查询当日数据
     *
     * @return 结果
     */
    EveryDayImage findTodayRecord();
}
