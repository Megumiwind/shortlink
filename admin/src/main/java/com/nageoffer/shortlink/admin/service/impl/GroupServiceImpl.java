package com.nageoffer.shortlink.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nageoffer.shortlink.admin.dao.entity.GroupDO;
import com.nageoffer.shortlink.admin.dao.mapper.GroupMapper;
import com.nageoffer.shortlink.admin.dto.resp.ShortLinkGroupRespDTO;
import com.nageoffer.shortlink.admin.service.GroupService;
import com.nageoffer.shortlink.admin.toolkit.RandomGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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
                .sortOrder(0)
                .name(name)
                .build();
        groupMapper.insert(groupDO);
    }

    @Override
    public List<ShortLinkGroupRespDTO> listGroup() {
        //TODO： 获取用户名
        LambdaQueryWrapper<GroupDO> wrapper = Wrappers.lambdaQuery(GroupDO.class)
                .isNull(GroupDO::getUsername)
                .orderByDesc(GroupDO::getSortOrder, GroupDO::getCreateTime);
        List<GroupDO> groupDOList = groupMapper.selectList(wrapper);
        return BeanUtil.copyToList(groupDOList, ShortLinkGroupRespDTO.class);
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
