package com.logistics.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.logistics.entity.Cardetail;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author q
 * @since 2019-05-04
 */
public interface CardetailService extends IService<Cardetail> {

     Page<Cardetail> selectpageid(int pageNo, int pageSize,int customerID);//根据customerID查询
     Page<Cardetail> selectpageall(int pageNO,int pageSize);//查询所有的订单
     Cardetail selectallid(String detailID);//根据id查询
     Page<Cardetail> selecttransID(Integer pageNo,Integer pageSize,Integer transID);
     Page<Cardetail>  Manyconditions(Integer pageNo,Integer pageSize,Cardetail cardetail);


}
