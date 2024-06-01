package com.tiger.tigerapp.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tiger.common.utils.Response;
import com.tiger.tigerapp.service.AppFeignClientService;
import com.tiger.tigerapp.service.RibbonService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: achilles
 * @Date: 2024/5/29
 * @Time: 14:59
 * @Remark:
 */
@Service
public class RibbonServiceImpl implements RibbonService {


    @Resource
    AppFeignClientService appFeignClientService;
    @Resource
    RestTemplate restTemplate;


    /**
     * 获取admin中数据
     * @return
     */
    @Override
    public Response getAdminData() {
        return appFeignClientService.getAdminData();
    }

    @HystrixCommand(fallbackMethod = "fallbackMethod")
    @Override
    public Response getAdminData2() {
        String url = "http://tigerAdmin/admin095ce/user/toAppData";
        return restTemplate.getForObject(url, Response.class);
    }

    public Response fallbackMethod() {
        return Response.of(500, "请求失败");
    }
}
