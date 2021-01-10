package top.vikingyang.lovinglambs.service.lovers.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.vikingyang.lovinglambs.entity.lovers.Lamb;
import top.vikingyang.lovinglambs.entity.lovers.bo.LambBo;
import top.vikingyang.lovinglambs.mapper.lovers.LambsMapper;
import top.vikingyang.lovinglambs.service.lovers.LambsService;

@Service
public class LambsServiceImpl implements LambsService {

    @Autowired
    private LambsMapper lambsMapper;

    @Override
    public Lamb findById(Long id) {
        return lambsMapper.selectByPrimaryKey(id);
    }

    @Override
    public void create(Lamb lamb) {
        lambsMapper.insertSelective(lamb);
    }

    @Override
    public void updateById(Lamb lamb) {
        lambsMapper.updateByPrimaryKeySelective(lamb);
    }

    /**
     * 寻找我的小羊
     *
     * @param userId 用户ID
     * @return 小羊信息
     */
    @Override
    public LambBo findMyLamb(Long userId) {
        LambBo lambBo = new LambBo();
        Lamb lamb = lambsMapper.findMyLamb(userId);
        if(lamb == null){
            lambBo.setHasSheepfold(false);
        }
        else{
            BeanUtils.copyProperties(lamb, lambBo);
            lambBo.setHasSheepfold(true);
        }
        return lambBo;
    }
}
