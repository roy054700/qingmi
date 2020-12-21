package com.qingmi.yi.modular.news.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 李龙真
 * @Date: 2020/12/17 13:48
 */
@RestController
@RequestMapping("/news")
@Slf4j
public class NewsController {

    @RequestMapping("/list")
    public String list(){

        return "今天你好！";
    }

}
