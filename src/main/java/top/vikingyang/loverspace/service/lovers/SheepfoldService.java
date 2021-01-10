package top.vikingyang.loverspace.service.lovers;

import top.vikingyang.loverspace.entity.lovers.Sheepfold;

public interface SheepfoldService {

    Sheepfold findById(Long id);

    void create(Sheepfold sheepfold);

    void updateById(Sheepfold sheepfold);

    /**
     * 创建小羊圈
     * @param inviterId 邀请者ID
     * @param inviteeId 被邀请者ID
     */
    void createSheepfold(Long inviterId, Long inviteeId);
}
