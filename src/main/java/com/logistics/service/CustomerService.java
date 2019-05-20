package com.logistics.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.logistics.entity.Customer;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author q
 * @since 2019-05-04
 */
public interface CustomerService extends IService<Customer> {

    Page<Customer> selectModelPage(int pageNo, int pageSize);

    Page<Customer> selectall(int pageNo,int pageSize,Customer customer);

}
