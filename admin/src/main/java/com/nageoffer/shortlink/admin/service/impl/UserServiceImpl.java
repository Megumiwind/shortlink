package com.nageoffer.shortlink.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nageoffer.shortlink.admin.dao.entity.UserDo;
import com.nageoffer.shortlink.admin.dao.mapper.UserMapper;
import com.nageoffer.shortlink.admin.dto.resp.UserRespDTO;
import com.nageoffer.shortlink.admin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDo> implements UserService {

    private final UserMapper userMapper;

    @Override
    public UserRespDTO getUserByUsername(String username) {
//        LambdaQueryWrapper<UserDo> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(UserDo::getUsername, username);
        LambdaQueryWrapper<UserDo> queryWrapper = Wrappers.lambdaQuery(UserDo.class).eq(UserDo::getUsername, username);
        UserDo userDo = baseMapper.selectOne(queryWrapper);
//        UserDo userDo = userMapper.selectOne(queryWrapper);
        UserRespDTO result = new UserRespDTO();

        if(userDo != null){
            BeanUtils.copyProperties(userDo, result);       // 此方法需要判空才可以，否则会报错
            return result;
        } else {
            return null;
        }

    }
}
