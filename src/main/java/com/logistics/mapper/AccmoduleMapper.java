package com.logistics.mapper;

import com.logistics.entity.Accmodule;
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
public interface AccmoduleMapper extends BaseMapper<Accmodule> {

   List<Accmodule> selAccModule(@Param("userID") Integer userID);

   void insAccModule(@Param("userID") Integer userID,@Param("moduleID") Integer[] moduleID);

   List<Accmodule> selectisexit(@Param("userID") Integer userID,@Param("moduleID") Integer[] moduleID);

    void delAccModule(@Param("userID") Integer userID,@Param("moduleID") Integer[] moduleID);

    List<Accmodule> selectisexitmodule(@Param("userID") Integer userID );
}
