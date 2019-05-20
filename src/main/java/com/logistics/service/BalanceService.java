package com.logistics.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.logistics.entity.Balance;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author q
 * @since 2019-05-04
 */
public interface BalanceService extends IService<Balance> {

    Page<Balance> page(int pageNo, int pageSize,Balance balance);//

    Page<Balance> selectfinance(int pageNo, int pageSize, Balance balance, String customerName, String paidTime1, String paidTime2);

    Page<Balance> selectcountall(int pageNo,int pageSize, String paidTime, String oprTime);
}
