package com.logistics.service.impl;

import com.logistics.entity.Accmodule;
import com.logistics.mapper.AccmoduleMapper;
import com.logistics.service.AccmoduleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author q
 * @since 2019-05-04
 */
@Service
public class AccmoduleServiceImpl extends ServiceImpl<AccmoduleMapper, Accmodule> implements AccmoduleService {

    @Autowired
    private AccmoduleMapper accmoduleMapper;
    @Override
    public List<Accmodule> selAccModule(Integer userID) {
        return this.accmoduleMapper.selAccModule(userID);
    }

    @Override
    public void insAccModule(Integer userID, Integer[] moduleID) {
       accmoduleMapper.insAccModule(userID,moduleID);
    }

    @Override
    public List<Accmodule> selectisexit(Integer userID, Integer[] moduleID) {
        return this.accmoduleMapper.selectisexit(userID,moduleID);
    }

    @Override
    public void delAccModule(Integer userID, Integer[] moduleID) {
        accmoduleMapper.delAccModule(userID,moduleID);
    }

    @Override
    public List<Accmodule> selectisexitmodule(Integer userID) {
        return this.accmoduleMapper.selectisexitmodule(userID);
    }
}
