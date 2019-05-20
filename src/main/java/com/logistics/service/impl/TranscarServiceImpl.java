package com.logistics.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.logistics.entity.Transcar;
import com.logistics.mapper.TranscarMapper;
import com.logistics.service.TranscarService;
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
public class TranscarServiceImpl extends ServiceImpl<TranscarMapper, Transcar> implements TranscarService {

    @Autowired
    private TranscarMapper transcarMapper;

    @Override
    public Page<Transcar> selectTranscarAll(int pageNo, int pageSiez) {
          Page<Transcar> page=new Page<Transcar>(pageNo,pageSiez);
        return page.setRecords(this.transcarMapper.selectTranscarAll(page));
    }


    @Override
    public Page<Transcar> selectcarStatus(Integer pageNo,Integer pageSize,String carStatus) {
        Page<Transcar> page=new Page<Transcar>(pageNo,pageSize);
        return   page.setRecords(this.transcarMapper.selectcarStatus(page,carStatus));
    }
}
