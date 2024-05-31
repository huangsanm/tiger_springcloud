package com.tiger.tigerapp.core.xxljob.job;

import com.xxl.job.core.handler.IJobHandler;
import groovy.util.logging.Slf4j;
import org.slf4j.LoggerFactory;

/**
 * @Author: achilles
 * @Date: 2024/5/30
 * @Time: 23:35
 * @Remark:
 */

@Slf4j
public class AppGameJobHandler extends IJobHandler {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(AppGameJobHandler.class);

    @Override
    public void execute() throws Exception {
        log.info("AppGameJobHandler, execute...");
    }

}
