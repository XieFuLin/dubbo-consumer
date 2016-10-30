package com.xfl.test.controller;

import com.xfl.common.controller.BaseController;
import com.xfl.common.entity.Response;
import com.xfl.common.enumeration.ResponseStatusEnum;
import com.xfl.provider.service.IDemoService;
import com.xfl.test.service.ITestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by XFL.
 * time on 2016/10/10 22:40
 * description:测试类
 */
@RestController
@RequestMapping("/Test")
public class TestController extends BaseController {
    /**
     * 该服务由dubbo服务提供者实现，也可以像本地bean一样的使用.
     */
    @Resource
    private IDemoService demoService;
    /**
     * 日志打印.
     */
    private final Logger log = LoggerFactory.getLogger(TestController.class);
    /**
     * 注入Service.
     */
    @Resource
    private ITestService testService;

    /**
     * 用于测试.
     *
     * @return 返回测试结果
     */
    @RequestMapping(method = RequestMethod.GET)
    public Response test() {
        log.info("Test");
        System.out.println(demoService.sayHello("String"));
        return new Response(ResponseStatusEnum.SUCCESS.getCode(), testService.test());
    }
}
