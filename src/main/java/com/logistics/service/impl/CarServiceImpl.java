package com.logistics.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.logistics.entity.Car;
import com.logistics.mapper.CarMapper;
import com.logistics.service.CarService;
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
public class CarServiceImpl extends ServiceImpl<CarMapper, Car> implements CarService {

    @Autowired
    private CarMapper carMapper;

    @Override
    public Page<Car> selectpageall(int pageNo, int pagesize) {
         Page<Car>  page=new Page<Car>(pageNo,pagesize);
         return page.setRecords(this.carMapper.selectpageall(page));
    }
}
