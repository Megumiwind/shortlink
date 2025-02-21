package com.nageoffer.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nageoffer.shortlink.admin.dao.entity.UserDo;
import com.nageoffer.shortlink.admin.dto.req.UserRegisterReqDTO;
import com.nageoffer.shortlink.admin.dto.req.UserUpdateReqDTO;
import com.nageoffer.shortlink.admin.dto.resp.UserRespDTO;

public interface UserService extends IService<UserDo> {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return 返回用户实体
     */
    UserRespDTO getUserByUsername(String username);

    /**
     * 查询用户名是否存在
     * @param username 用户名
     * @return 若存在返回true
     */
    boolean hasUsername(String username);

    /**
     * 用户注册
     * @param requestParam 用户注册请求参数
     */
    void register(UserRegisterReqDTO requestParam);

    /**
     * 修改用户
     * @param requestParam 修改用户请求参数
     */
    void update(UserUpdateReqDTO requestParam);
}
