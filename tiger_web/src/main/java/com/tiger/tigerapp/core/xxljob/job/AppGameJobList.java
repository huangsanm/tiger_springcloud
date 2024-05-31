package com.tiger.tigerapp.core.xxljob.job;

import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

/**
 * @Author: achilles
 * @Date: 2024/5/30
 * @Time: 23:42
 * @Remark:
 */

@Component
public class AppGameJobList {

    @XxlJob("doSomeThingJobHandler")
    public void doSomeThingJobHandler(){

    }




}
