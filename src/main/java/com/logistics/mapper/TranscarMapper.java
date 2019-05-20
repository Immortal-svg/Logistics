package com.logistics.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.logistics.entity.Transcar;
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
public interface TranscarMapper extends BaseMapper<Transcar> {

    List<Transcar> selectTranscarAll(Pagination page);

    List<Transcar>  selectcarStatus(Pagination page,@Param("carStatus")String carStatus);

}
