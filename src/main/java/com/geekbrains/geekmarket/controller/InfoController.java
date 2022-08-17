package com.geekbrains.geekmarket.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/info1")
@Slf4j
public class InfoController {

    private final String appName;

    public InfoController(@Value("${geek.market.app-name}") String appName,
                          @Value("#{1 + 2}") Integer three
    ) {
        this.appName = appName;
        log.debug("{}", three);
    }

    @GetMapping
    public String getAppName() {
        return appName;
    }
}
