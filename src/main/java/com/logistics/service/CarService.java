package com.logistics.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.logistics.entity.Car;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author q
 * @since 2019-05-04
 */
public interface CarService extends IService<Car> {

    Page<Car> selectpageall(int pageNo,int pagesize);

}
