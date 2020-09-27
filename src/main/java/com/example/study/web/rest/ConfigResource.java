package com.example.study.web.rest;

import com.example.study.service.ConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: study
 * @description:
 * @author: WangJJ
 * @create: 2020-09-27 18:26
 **/
@Api(tags = "配置文件")
@RestController
@RequestMapping("config")
public class ConfigResource {

    private final ConfigService configService;

    public ConfigResource(ConfigService configService) {
        this.configService = configService;
    }

    @ApiOperation("获取yml文件里面的student")
    @GetMapping("get")
    public ResponseEntity<String> config(){
        return ResponseEntity.ok(configService.student());
    }
}
