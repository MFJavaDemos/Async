package com.mf.asyncdemo.Async;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: chang
 * @create: 2020-08-24 15:01
 **/
@RestController
public class UserTestController {

    private final AsyncService asyncService;

    public UserTestController(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    @GetMapping(value = "/testLog")
    public String hello() {
        asyncService.async();
        return "testLog";
    }

}
