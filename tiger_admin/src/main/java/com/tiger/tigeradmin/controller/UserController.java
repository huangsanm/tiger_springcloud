package com.tiger.tigeradmin.controller;

import com.alibaba.fastjson2.JSONObject;
import com.tiger.common.utils.Response;
import com.tiger.tigeradmin.controller.body.UserRequest;
import com.tiger.tigeradmin.service.AdminFeignClientService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: achilles
 * @Date: 2024/5/27
 * @Time: 11:00
 * @Remark:
 */
@RestController
@RequestMapping("/admin095ce/user")
public class UserController {

    @Resource
    AdminFeignClientService adminFeignClientService;
    @Resource
    RestTemplate restTemplate;

    @PostMapping("createUser")
    public Response createUser(@RequestBody UserRequest userRequest){
        return Response.of(userRequest);
    }

    @GetMapping("getAllUser")
    public Response getAllUser(){
        return Response.of(1);
    }

    @GetMapping("getAppData")
    public Response getAppData(){
        return adminFeignClientService.getAppData();
    }

    @GetMapping("toAppData")
    public Response toAppData(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", "this data from app");
        return Response.of(jsonObject);
    }

    @GetMapping("getTest2")
    public Response getTest2(){
        JSONObject params = new JSONObject();
        params.put("dddd", "ddddddddd");
        return Response.of(params);
    }

    @GetMapping("testAppBalance")
    public Response testAppBalance(){
        String appUri = "http://tigerApp/appokqche/app/testBalance";
        return restTemplate.getForObject(appUri, Response.class);
    }



}
