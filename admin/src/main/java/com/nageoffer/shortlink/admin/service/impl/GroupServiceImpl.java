package com.nageoffer.shortlink.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nageoffer.shortlink.admin.dao.entity.GroupDO;
import com.nageoffer.shortlink.admin.dao.mapper.GroupMapper;
import com.nageoffer.shortlink.admin.service.GroupService;
import com.nageoffer.shortlink.admin.toolkit.RandomGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class GroupServiceImpl extends ServiceImpl<GroupMapper, GroupDO> implements GroupService {

    private final GroupMapper groupMapper;

    @Override
    public void saveGroup(String name) {
        String gid;
        do {
            gid = RandomGenerator.generateFixLenRandomString();
        } while (hasGid(gid));

        GroupDO groupDO = GroupDO.builder()
                .gid(RandomGenerator.generateFixLenRandomString())
                .name(name)
                .build();
        groupMapper.insert(groupDO);
    }

    private boolean hasGid(String gid) {
        LambdaQueryWrapper<GroupDO> wrapper = Wrappers.lambdaQuery(GroupDO.class)
                //TODO: 设置用户名
                .eq(GroupDO::getUsername, null)
                .eq(GroupDO::getGid, gid);
        GroupDO one = groupMapper.selectOne(wrapper);
        return one != null;
    }
}
