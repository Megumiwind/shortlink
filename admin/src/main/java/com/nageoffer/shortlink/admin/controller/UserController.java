package com.nageoffer.shortlink.admin.controller;

import cn.hutool.core.bean.BeanUtil;
import com.nageoffer.shortlink.admin.common.convention.result.Result;
import com.nageoffer.shortlink.admin.common.convention.result.Results;
import com.nageoffer.shortlink.admin.dto.req.UserRegisterReqDTO;
import com.nageoffer.shortlink.admin.dto.req.UserUpdateReqDTO;
import com.nageoffer.shortlink.admin.dto.resp.UserActualRespDTO;
import com.nageoffer.shortlink.admin.dto.resp.UserRespDTO;
import com.nageoffer.shortlink.admin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/short-link/v1")
public class UserController {

//    @Autowired
    private final UserService userService;


    /**
     * 根据用户名查询用户信息，脱敏后的
     * @param username
     * @return
     */
    @GetMapping("user/{username}")
    public Result<UserRespDTO> getUserByUserName(@PathVariable String username) {
        UserRespDTO result = userService.getUserByUsername(username);
        return Results.success(result);
    }

    /**
     * 根据用户名查询用户信息，脱敏后的
     * @param username
     * @return
     */
    @GetMapping("actual/user/{username}")
    public Result<UserActualRespDTO> getActualUserByUserName(@PathVariable String username) {
        return Results.success(BeanUtil.toBean(userService.getUserByUsername(username), UserActualRespDTO.class));
    }

    @GetMapping("user/has-username")
    public Result<Boolean> hasUserName(@RequestParam("username") String username) {
        return Results.success(userService.hasUsername(username));
    }

    @PostMapping("user")
    public Result<?> register(@RequestBody UserRegisterReqDTO requsetParam) {
        userService.register(requsetParam);
        return Results.success();
    }

    /**
     * 根据用户名修改用户
     * @param requestParam 修改用户请求参数
     * @return
     */
    @PutMapping("user")
    public Result<?> update(@RequestBody UserUpdateReqDTO requestParam) {
        userService.update(requestParam);
        return Results.success();
    }
}
