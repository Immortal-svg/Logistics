package com.logistics.service;

import com.baomidou.mybatisplus.service.IService;
import com.logistics.entity.Accmodule;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author q
 * @since 2019-05-04
 */
public interface AccmoduleService extends IService<Accmodule> {


    List<Accmodule> selAccModule(Integer userID);//通过用户id查询

     void insAccModule(Integer userID,Integer[] moduleID);

     List<Accmodule> selectisexit(Integer userID,Integer[] moduleID);

     void    delAccModule(Integer userID,Integer[] moduleID);

    List<Accmodule> selectisexitmodule(Integer userID );


}
