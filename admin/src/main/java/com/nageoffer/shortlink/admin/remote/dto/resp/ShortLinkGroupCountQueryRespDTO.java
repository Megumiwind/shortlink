package com.nageoffer.shortlink.admin.remote.dto.resp;

import lombok.Data;

/**
 * 短链接分组查询计数返回参数
 */
@Data
public class ShortLinkGroupCountQueryRespDTO {

    private String gid;

    /**
     * 分组下短链接数量
     */
    private Integer shortLinkCount;
}
