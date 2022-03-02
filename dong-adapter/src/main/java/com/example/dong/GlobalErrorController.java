package com.example.dong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @Author: 廖冬年
 * @Date: 2022/3/2 9:52 AM
 *
 */

@Controller
public class GlobalErrorController extends BasicErrorController {

    @Autowired
    public GlobalErrorController(ServerProperties errorAttributes) {
        super(new DefaultErrorAttributes(), errorAttributes.getError());
    }

    @Override
    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
        return super.errorHtml(request, response);
    }

    @Override
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        Map<String, Object> body = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.ALL));
        HttpStatus status = getStatus(request);

        Map<String, Object> map = new HashMap<>();
        map.put("code", 100);
        map.put("status", true);
        map.put("data", "");
        return new ResponseEntity<>(map, HttpStatus.valueOf(200));
    }
}
