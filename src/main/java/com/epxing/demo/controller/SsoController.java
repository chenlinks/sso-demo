package com.epxing.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.epxing.demo.config.AppRuntimeEnv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenling
 * @date 2020/5/12 21:49
 * @since V1.0.0
 */
@RestController
@RequestMapping("/api/v1/test")
public class SsoController {

    @Autowired
    private AppRuntimeEnv appRuntimeEnv;

    @GetMapping("/sso")
    public String testSso(){

        Map<String,Object> result = new HashMap<>(4);
        result.put("code","00001");
        result.put("msg","ok");
        result.put("userName",appRuntimeEnv.getUsername());
        result.put("token",appRuntimeEnv.getToken());
        return JSONObject.toJSONString(result);

    }
}
