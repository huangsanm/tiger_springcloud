package com.tiger.common.entity.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * @Author: achilles
 * @Date: 2024/5/27
 * @Time: 10:50
 * @Remark:
 */
@Data
public class BaseEntity {


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //@Column(value = "create_time", onInsertValue = "now()")
    private String createTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //@Column(value = "last_modify_time", onInsertValue = "now()")
    private String lastModifyTime;

    //@CreatedBy
    private Long creatorUserId;

    //@LastModifiedBy
    private Long lastModifyUserId;


}
