package com.example.dong.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @Author: 廖冬年
 * @Date: 2022/1/25 5:13 PM
 *
 */
@RestController
public class UserController {

    @PostMapping("/api/login")
    public String insert111(@RequestBody String json) {
        return "success";
    }

    @GetMapping("/api/test")
    public String insert222ww() {
        return "success tet";
    }

    @PostMapping("/api/test1")
    @PreAuthorize("hasAnyRole('MENU1')")
    public String insert222(@RequestBody String json) {
        return "success11";
    }

    @PostMapping("/api/test2")
    @PreAuthorize("hasAnyRole('MENU5')")
    public String inser333(@RequestBody String json) {
        return "success11";
    }
}
