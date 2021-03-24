package com.qingmi.yi.modular.forum.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qingmi.yi.modular.forum.mapper.CustomerUserMapper;
import com.qingmi.yi.modular.forum.model.CustomerUser;
import com.qingmi.yi.modular.forum.service.CustomerUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: 李龙真
 * @Date: 2021/3/11 13:33
 */
@Service
@Transactional
public class CustomerUserServiceImpl extends ServiceImpl<CustomerUserMapper, CustomerUser> implements CustomerUserService {
}
