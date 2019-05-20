package com.logistics.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.logistics.entity.Balance;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author q
 * @since 2019-05-04
 */
public interface BalanceMapper extends BaseMapper<Balance> {

    List<Balance>  page(Pagination page,@Param(value =  "balance") Balance balance);//通过customerid查询
    //客户往来明细
    List<Balance> selectfinance(Pagination page,
        @Param("balance") Balance balance,@Param("customerName") String customerName,@Param("paidTime1") String paidTime1,@Param("paidTime2") String paidTime2);
    //客户往来统计
    List<Balance>  selectcountall(Pagination page,@Param("paidTime") String paidTime,@Param("oprTime") String oprTime);
}
