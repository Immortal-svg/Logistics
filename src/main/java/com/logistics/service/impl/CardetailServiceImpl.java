package com.logistics.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.logistics.entity.Cardetail;
import com.logistics.mapper.CardetailMapper;
import com.logistics.service.CardetailService;
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
public class CardetailServiceImpl extends ServiceImpl<CardetailMapper, Cardetail> implements CardetailService {

    @Autowired
    private CardetailMapper cardetailMapper;

    @Override
    public Page<Cardetail> selectpageid(int pageNo, int pageSize, int customerID) {
        Page<Cardetail> page=new Page<Cardetail>(pageNo,pageSize);
        return page.setRecords(this.cardetailMapper.selectpageid(page,customerID));
    }

    @Override
    public Page<Cardetail> selectpageall(int pageNO, int pageSize) {
        Page<Cardetail> page=new Page<Cardetail>(pageNO,pageSize);
        return page.setRecords(this.cardetailMapper.selectpageall(page));
    }

    @Override
    public Cardetail selectallid(String detailID) {
        return cardetailMapper.selectallid(detailID);
    }

    @Override
    public Page<Cardetail> selecttransID(Integer pageNo, Integer pageSize, Integer transID) {
        Page<Cardetail> page=new Page<Cardetail>(pageNo,pageSize);
        return page.setRecords(this.cardetailMapper.selecttransID(page,transID));
    }

    @Override
    public Page<Cardetail> Manyconditions(Integer pageNo, Integer pageSize, Cardetail cardetail) {
        Page<Cardetail> page=new Page<Cardetail>(pageNo,pageSize);
        return page.setRecords(this.cardetailMapper.Manyconditions(page,cardetail));

    }
}
