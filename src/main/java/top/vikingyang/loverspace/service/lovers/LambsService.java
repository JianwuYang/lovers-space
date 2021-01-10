package top.vikingyang.loverspace.service.lovers;

import top.vikingyang.loverspace.entity.lovers.Lamb;

public interface LambsService {

    Lamb findById(Long id);

    void create(Lamb lamb);

    void updateById(Lamb lamb);
}
