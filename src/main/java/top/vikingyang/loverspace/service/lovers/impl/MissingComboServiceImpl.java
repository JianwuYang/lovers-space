package top.vikingyang.loverspace.service.lovers.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.vikingyang.loverspace.entity.common.Constants;
import top.vikingyang.loverspace.entity.lovers.MissingCombo;
import top.vikingyang.loverspace.entity.lovers.bo.MissingComboBo;
import top.vikingyang.loverspace.entity.lovers.vo.MissingComboVo;
import top.vikingyang.loverspace.mapper.lovers.MissingComboMapper;
import top.vikingyang.loverspace.service.lovers.MissingComboService;
import top.vikingyang.loverspace.util.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class MissingComboServiceImpl implements MissingComboService {

    @Autowired
    private MissingComboMapper missingComboMapper;

    private static final SimpleDateFormat sdf = new SimpleDateFormat(Constants.YYYY_MM_DD);

    @Override
    public MissingCombo findById(Long id) {
        return missingComboMapper.selectByPrimaryKey(id);
    }

    @Override
    public void create(MissingCombo missingCombo) {
        missingComboMapper.insertSelective(missingCombo);
    }

    @Override
    public void updateById(MissingCombo missingCombo) {
        missingComboMapper.updateByPrimaryKeySelective(missingCombo);
    }

    /**
     * 根据小羊ID查询思念连击信息
     *
     * @param lambId 小羊ID
     * @return 结果
     */
    @Override
    public MissingComboBo findByLambId(Long lambId) {
        MissingComboBo missingComboBo = new MissingComboBo();
        MissingCombo missingCombo = missingComboMapper.findByLambId(lambId);
        Date today = new Date();
        String todayStr = sdf.format(new Date());
        Date yesterday = DateUtil.addDay(today, -1);
        String yesterdayStr = sdf.format(yesterday);
        // 不为空/昨天/今天（从未签到或断签）
        if(missingCombo == null
                || !todayStr.equals(missingCombo.getMissingDate())
                || !yesterdayStr.equals(missingCombo.getMissingDate())){
            missingComboBo.setHasMiss(false);
            missingComboBo.setMissingDate(todayStr);
            missingComboBo.setLambId(lambId);
            missingComboBo.setCombo(0);
        }
        // 昨天（今日未签到）
        else if(yesterdayStr.equals(missingCombo.getMissingDate())){
            BeanUtils.copyProperties(missingCombo, missingComboBo);
            missingComboBo.setHasMiss(false);
        }
        // 今天（今日已签到）
        else {
            BeanUtils.copyProperties(missingCombo, missingComboBo);
            missingComboBo.setHasMiss(true);
        }
        return missingComboBo;
    }

    /**
     * 创建今日思念
     *
     * @param missingComboVo 昨日签到信息
     */
    @Override
    public void createTodayMissing(MissingComboVo missingComboVo) {
        MissingCombo missingCombo = new MissingCombo();
        missingCombo.setLambId(missingComboVo.getLambId());
        missingCombo.setCombo(missingComboVo.getCombo() + 1);
        Date today = new Date();
        String todayStr = sdf.format(today);
        missingCombo.setMissingDate(todayStr);
        this.create(missingCombo);
    }
}
