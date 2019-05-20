package com.logistics.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.logistics.entity.Customer;
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
public interface CustomerMapper extends BaseMapper<Customer> {

    List<Customer> selectModelPage(Pagination page);

    List<Customer> selectall(Pagination page,@Param("customer") Customer customer);

}
