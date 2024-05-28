package com.tiger.common.entity;

import com.tiger.common.entity.base.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: achilles
 * @Date: 2024/5/27
 * @Time: 10:43
 * @Remark:
 */
@Data
public class SysRole extends BaseEntity implements Serializable {

    private Long id;
    private String roleName;

}
