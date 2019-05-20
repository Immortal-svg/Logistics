package com.logistics.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.logistics.entity.Car;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author q
 * @since 2019-05-04
 */
public interface CarMapper extends BaseMapper<Car> {


    List<Car> selectpageall(Pagination page);//

}
