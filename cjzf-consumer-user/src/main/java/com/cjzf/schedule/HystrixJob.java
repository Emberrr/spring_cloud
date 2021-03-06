//package com.cjzf.schedule;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang.exception.ExceptionUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import com.cjzf.service.TestClient;
//
//import javax.annotation.Resource;
//
///**
// * @ClassName FilterConfig
// * @Description
// * @author nicholas
// * @Date 2018年1月10日 下午14:13:26
// * @version 1.0.1
// */
//@Component
////开启定时任务
//@EnableScheduling
//@Slf4j
//public class HystrixJob {
//    private static final Logger log = LoggerFactory.getLogger(HystrixJob.class);
//
//    @Resource
//    private TestClient testClient;
//
//    @Scheduled(cron = "0/20 * * * * ?")
//    public void doJob() {
//        try {
//            testClient.test();
//        } catch (Exception e) {
//            log.info("exception message is:{}", ExceptionUtils.getStackTrace(e));
//        }
//    }
//}