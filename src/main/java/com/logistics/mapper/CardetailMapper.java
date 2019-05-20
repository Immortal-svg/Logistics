package com.logistics.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.logistics.entity.Cardetail;
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
public interface CardetailMapper extends BaseMapper<Cardetail> {

    List<Cardetail> selectpageid(Pagination page,@Param("customerID") Integer customerID);//通过cusotomerID查询
    List<Cardetail>  selectpageall(Pagination page);//查询所有
    Cardetail selectallid(@Param("detailID") String detailID );//通过订单id查询
    List<Cardetail> selecttransID(Pagination page,@Param("transID")Integer transID );//通过transID查询
    List<Cardetail> Manyconditions(Pagination page,@Param("cardetail") Cardetail cardetail);

}
