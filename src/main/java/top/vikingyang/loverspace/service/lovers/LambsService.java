package top.vikingyang.loverspace.service.lovers;

import top.vikingyang.loverspace.entity.lovers.Lamb;
import top.vikingyang.loverspace.entity.lovers.bo.LambBo;

public interface LambsService {

    Lamb findById(Long id);

    void create(Lamb lamb);

    void updateById(Lamb lamb);

    /**
     * 寻找我的小羊
     * @param userId 用户ID
     * @return 小羊信息
     */
    LambBo findMyLamb(Long userId);
}
