package com.tiger.tigerapp.controller;

import cn.hutool.core.lang.UUID;
import com.alibaba.fastjson2.JSONObject;
import com.tiger.common.utils.Response;
import com.tiger.tigerapp.service.AppFeignClientService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: achilles
 * @Date: 2024/5/29
 * @Time: 11:08
 * @Remark:
 */
@RestController
@RequestMapping("/appokqche/app")
public class AppController {

    @Resource
    AppFeignClientService appFeignClientService;

    @GetMapping("testBalance")
    public Response testBalance(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", UUID.randomUUID().toString());
        return Response.of(jsonObject);
    }


    @GetMapping("/home")
    public Response home(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", "this app");
        return Response.of(jsonObject);
    }

    @GetMapping("toAdminData")
    public Response toAdminData(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", "this data from app client");
        return Response.of(jsonObject);
    }

    @GetMapping("getWebData")
    public Response getWebData(){
        return appFeignClientService.getAdminData();
    }


}