package top.vikingyang.loverspace.service.lovers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.vikingyang.loverspace.entity.admin.User;
import top.vikingyang.loverspace.entity.lovers.Lamb;
import top.vikingyang.loverspace.entity.lovers.Sheepfold;
import top.vikingyang.loverspace.mapper.lovers.SheepfoldMapper;
import top.vikingyang.loverspace.service.admin.UserService;
import top.vikingyang.loverspace.service.lovers.LambsService;
import top.vikingyang.loverspace.service.lovers.SheepfoldService;

import java.util.Date;

@Service
public class SheepfoldServiceImpl implements SheepfoldService {

    @Autowired
    private SheepfoldMapper sheepfoldMapper;

    @Autowired
    private LambsService lambsService;

    @Autowired
    private UserService userService;

    @Override
    public Sheepfold findById(Long id) {
        return sheepfoldMapper.selectByPrimaryKey(id);
    }

    @Override
    public void create(Sheepfold sheepfold) {
        sheepfoldMapper.insertSelective(sheepfold);
    }

    @Override
    public void updateById(Sheepfold sheepfold) {
        sheepfoldMapper.updateByPrimaryKeySelective(sheepfold);
    }

    /**
     * 创建小羊圈
     *
     * @param inviterId 邀请者ID
     * @param inviteeId 被邀请者ID
     */
    @Override
    public void createSheepfold(Long inviterId, Long inviteeId) {
        // 获取邀请者用户信息
        User inviter = userService.findById(inviterId);
        User invitee = userService.findById(inviteeId);

        // 创建小羊圈
        Sheepfold sheepfold = new Sheepfold();
        Date now = new Date();
        sheepfold.setLoveTime(now);
        sheepfold.setCreator(inviter.getUserName());
        sheepfold.setUpdater(sheepfold.getCreator());
        this.create(sheepfold);

        // 创建小羊
        createLamb(inviter, sheepfold, inviter.getUserName());
        createLamb(invitee, sheepfold, inviter.getUserName());
    }

    /**
     * 创建小羊逻辑
     * @param user 用户
     * @param sheepfold 小羊圈
     * @param userName 创建用户名
     */
    private void createLamb(User user, Sheepfold sheepfold, String userName) {
        Lamb lamb = new Lamb();
        lamb.setUserId(user.getId());
        lamb.setPetName(user.getUserName());
        lamb.setFoldId(sheepfold.getId());
        lamb.setCreator(userName);
        lamb.setUpdater(lamb.getCreator());
        lambsService.create(lamb);
    }
}
