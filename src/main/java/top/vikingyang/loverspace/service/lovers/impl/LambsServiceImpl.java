package top.vikingyang.loverspace.service.lovers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.vikingyang.loverspace.entity.lovers.Lamb;
import top.vikingyang.loverspace.mapper.lovers.LambsMapper;
import top.vikingyang.loverspace.service.lovers.LambsService;

@Service
public class LambsServiceImpl implements LambsService {

    @Autowired
    private LambsMapper lambsMapper;

    @Override
    public Lamb findById(Long id) {
        return null;
    }

    @Override
    public void create(Lamb lamb) {

    }

    @Override
    public void updateById(Lamb lamb) {

    }
}
