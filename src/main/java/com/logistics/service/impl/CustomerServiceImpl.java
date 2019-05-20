package com.logistics.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.logistics.entity.Customer;
import com.logistics.mapper.CustomerMapper;
import com.logistics.service.CustomerService;
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
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Page<Customer> selectModelPage(int pageNo, int pageSize) {
        Page<Customer> page=new Page<Customer>(pageNo,pageSize);
        return  page.setRecords(this.customerMapper.selectModelPage(page));
    }

    @Override
    public Page<Customer> selectall(int pageNo, int pageSize, Customer customer) {
        Page<Customer> page=new Page<Customer>(pageNo,pageSize);
        return  page.setRecords(this.customerMapper.selectall(page,customer));
    }
}
