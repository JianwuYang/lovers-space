package top.vikingyang.loverspace.service.lovers;

import top.vikingyang.loverspace.entity.lovers.MissingCombo;

public interface MissingComboService {

    MissingCombo findById(Long id);

    void create(MissingCombo missingCombo);

    void updateById(MissingCombo missingCombo);
}
