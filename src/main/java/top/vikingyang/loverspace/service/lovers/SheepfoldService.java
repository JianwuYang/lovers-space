package top.vikingyang.loverspace.service.lovers;

import top.vikingyang.loverspace.entity.lovers.Sheepfold;

public interface SheepfoldService {

    Sheepfold findById(Long id);

    void create(Sheepfold sheepfold);

    void updateById(Sheepfold sheepfold);
}
