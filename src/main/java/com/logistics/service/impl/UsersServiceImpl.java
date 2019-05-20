package com.logistics.service.impl;

import com.logistics.entity.Users;
import com.logistics.mapper.UsersMapper;
import com.logistics.service.UsersService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
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
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

}
