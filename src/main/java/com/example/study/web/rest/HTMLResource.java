package com.example.study.web.rest;

import com.example.study.service.DTO.URLContentDTO;
import com.example.study.service.GetHTMLService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: study
 * @description:
 * @author: WangJJ
 * @create: 2020-09-10 12:43
 **/
@Api("杂")
@RestController
@RequestMapping("/html")
public class HTMLResource {

    private final Logger log = LoggerFactory.getLogger(HTMLResource.class);

    private final GetHTMLService getHTMLService;

    public HTMLResource(GetHTMLService getHTMLService) {
        this.getHTMLService = getHTMLService;
    }

    /**
     * 原始状态：
     *   apnic |          CN        |  ipv4  |1.2.2.0|   256  |20110331|assigned
     * 等级机构|获得该IP段的国家/组织|资源类型| 起始IP |IP段长度|分配日期|分配状态
     */
    @ApiOperation("1.HttpURLConnection获取中国地区IP")
    @GetMapping("/bb")
    public ResponseEntity<String> bb(){
        System.out.println("==========stat get apnicIp==========");
        String s = getHTMLService.dididi();
        System.out.println("==========end  get apnicIp==========");
        return ResponseEntity.ok(s);
    }

    @ApiOperation("2.识别URL内容(爬取标题，内容，icon)")
    @GetMapping("/get-content")
    public ResponseEntity<URLContentDTO> getURLContent(@RequestParam(name = "url") String url) throws Exception {
        URLContentDTO urlContentDTO = getHTMLService.getContent(url);
        return ResponseEntity.ok(urlContentDTO);
    }
}
