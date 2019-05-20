package com.logistics.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.logistics.entity.Carroad;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author q
 * @since 2019-05-04
 */
public interface CarroadService extends IService<Carroad> {

    Page<Carroad> selectpagetrandID(Integer pageNo,Integer pageSize,Carroad carroad);

}
