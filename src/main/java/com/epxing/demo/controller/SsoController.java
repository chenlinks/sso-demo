package com.epxing.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenling
 * @date 2020/5/12 21:49
 * @since V1.0.0
 */
@RestController
@RequestMapping("/api/v1/test")
public class SsoController {



    @GetMapping("/sso")
    public void testSso(){




    }
}
