package com.tiger.tigeradmin.controller;

import com.tiger.common.utils.Response;
import com.tiger.tigeradmin.controller.body.UserRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: achilles
 * @Date: 2024/5/27
 * @Time: 11:00
 * @Remark:
 */
@RestController
@RequestMapping("/admin095ce/user")
public class UserController {


    @PostMapping("createUser")
    public Response createUser(@RequestBody UserRequest userRequest){
        return Response.of(userRequest);
    }

    @GetMapping("getAllUser")
    public Response getAllUser(){
        return Response.of(1);
    }


}
