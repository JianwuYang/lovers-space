package top.vikingyang.loverspace.service.lovers;

import top.vikingyang.loverspace.entity.lovers.MissingCombo;
import top.vikingyang.loverspace.entity.lovers.bo.MissingComboBo;
import top.vikingyang.loverspace.entity.lovers.vo.MissingComboVo;

public interface MissingComboService {

    MissingCombo findById(Long id);

    void create(MissingCombo missingCombo);

    void updateById(MissingCombo missingCombo);

    /**
     * 根据小羊ID查询思念连击信息
     * @param lambId 小羊ID
     * @return 结果
     */
    MissingComboBo findByLambId(Long lambId);

    /**
     * 创建今日思念
     * @param missingComboVo 昨日签到信息
     */
    void createTodayMissing(MissingComboVo missingComboVo);
}
