package com.tiger.tigeradmin.controller;

import com.tiger.common.utils.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: achilles
 * @Date: 2024/5/27
 * @Time: 11:00
 * @Remark:
 */
@RestController("/admin095ce/role")
public class RoleController {

    @GetMapping("getAllRole")
    public Response getAllRole() {
        return Response.of(null);
    }

}
