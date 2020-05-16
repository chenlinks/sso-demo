package com.epxing.demo.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenling
 * @date 2020/5/16 16:10
 * @since V1.0.0
 */

@RestController
@RequestMapping("/api/v1/test")
public class SsoController {

    @GetMapping("/sso")
    public String testSso(){

        Map<String,Object> result = new HashMap<>(4);
        result.put("code","00001");
        result.put("msg","ok");
        return JSONObject.toJSONString(result);

    }
}
