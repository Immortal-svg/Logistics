package com.logistics.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.logistics.entity.Carroad;
import com.logistics.mapper.CarroadMapper;
import com.logistics.service.CarroadService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author q
 * @since 2019-05-04
 */
@Service
public class CarroadServiceImpl extends ServiceImpl<CarroadMapper, Carroad> implements CarroadService {

    @Autowired
    private CarroadMapper carroadMapper;

    @Override
    public Page<Carroad> selectpagetrandID(Integer pageNo, Integer pageSize,Carroad carroad) {
        Page<Carroad> page=new Page<Carroad>(pageNo,pageSize);
        return  page.setRecords(this.carroadMapper.selectpagetrandID(page,carroad));
    }
}
