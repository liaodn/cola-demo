package com.example.dong.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @Author: 廖冬年
 * @Date: 2022/3/2 10:44 AM
 *
 */
@Controller
@RequestMapping("/error")
public class ErrorController {

    /**
     * 404页面
     */
    @GetMapping(value = "/404")
    public String error_404() {
        return "common/error_404";
    }

    /**
     * 500页面
     */
    @GetMapping(value = "/500")
    public String error_500() {
        return "common/error_500";
    }

}