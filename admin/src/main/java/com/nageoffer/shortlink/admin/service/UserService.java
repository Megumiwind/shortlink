package com.nageoffer.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nageoffer.shortlink.admin.dao.entity.UserDo;
import com.nageoffer.shortlink.admin.dto.resp.UserRespDTO;

public interface UserService extends IService<UserDo> {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return 返回用户实体
     */
    UserRespDTO getUserByUsername(String username);
}
