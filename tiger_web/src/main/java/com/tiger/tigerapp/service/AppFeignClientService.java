package com.tiger.tigerapp.service;

import com.tiger.common.utils.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: achilles
 * @Date: 2024/5/29
 * @Time: 11:49
 * @Remark:
 */
@FeignClient(name = "AppFeignClient", url = "http://127.0.0.1:8400")
public interface AppFeignClientService {


    @GetMapping("/admin095ce/user/toAppData")
    Response getAdminData();


}
