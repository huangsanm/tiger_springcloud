package com.tiger.tigeradmin.service;

import com.tiger.common.utils.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: achilles
 * @Date: 2024/5/29
 * @Time: 11:40
 * @Remark:
 */
@FeignClient(name = "AdminFeignClient", url = "http://127.0.0.1:8500")
public interface AdminFeignClientService {


    @GetMapping("/appokqche/app/toAdminData")
    Response getAppData();



}
