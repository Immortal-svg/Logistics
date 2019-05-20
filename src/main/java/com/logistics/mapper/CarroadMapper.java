package com.logistics.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.logistics.entity.Carroad;
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
public interface CarroadMapper extends BaseMapper<Carroad> {
    //根据trandID分页查询
    List<Carroad> selectpagetrandID(Pagination page,@Param("carroad")Carroad carroad);

}
