package com.nageoffer.shortlink.admin.controller;

import com.nageoffer.shortlink.admin.dto.resp.UserRespDTO;
import com.nageoffer.shortlink.admin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

//    @Autowired
    private final UserService userService;

    @GetMapping("/api/shortlink/v1/user/{username}")
    public UserRespDTO getUserByUserName(@PathVariable String username) {
//        LambdaQueryWrapper<UserDo> queryWrapper = Wrappers.lambdaQuery(UserDo.class).eq(UserDo::getUsername, username);
//        UserDo one = userService.getOne(queryWrapper);
//        UserRespDTO userRespDTO = new UserRespDTO();
//        BeanUtils.copyProperties(one, userRespDTO);
//        return userRespDTO;
        return userService.getUserByUsername(username);
    }
}
