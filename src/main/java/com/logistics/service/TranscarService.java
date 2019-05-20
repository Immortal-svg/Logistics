package com.logistics.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.logistics.entity.Transcar;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author q
 * @since 2019-05-04
 */
public interface TranscarService extends IService<Transcar> {

    Page<Transcar> selectTranscarAll(int  pageNo,int pageSiez);

    Page<Transcar> selectcarStatus(Integer pageNo,Integer pageSize,String carStatus);

}
