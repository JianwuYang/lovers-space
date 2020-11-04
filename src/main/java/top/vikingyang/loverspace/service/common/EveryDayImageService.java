package top.vikingyang.loverspace.service.common;

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
     * 每日图片JSON获取
     * @return 数据
     */
    EveryDayImage getEveryDayImageJSON();

    /**
     * 每日图片数据获取
     * @param image 数据
     */
    EveryDayImage getEveryDayImageData(EveryDayImage image);
}
