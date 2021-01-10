package top.vikingyang.lovinglambs.service.lovers;

import top.vikingyang.lovinglambs.entity.lovers.Lamb;
import top.vikingyang.lovinglambs.entity.lovers.bo.LambBo;

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
