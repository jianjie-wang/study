package com.example.study.web.rest;

import com.example.study.config.StudentNameProperties;
import com.example.study.service.DTO.EsBlogDTO;
import com.example.study.service.EsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: study
 * @description:
 * @author: WangJJ
 * @create: 2020-09-16 15:48
 **/
@Api(tags = "ES测试")
@RestController
@RequestMapping("/Elastic")
public class EsRepository {
    private final Logger log = LoggerFactory.getLogger(EsRepository.class);

    private final EsService esService;
    public EsRepository(EsService esService) {
        this.esService = esService;
    }

    @ApiOperation("fkdfgjfkds")
    @GetMapping(value = "/get")
    public ResponseEntity<Page<EsBlogDTO>> elasticSearch(Pageable pageable){

        Page<EsBlogDTO> esBlogDTOS = esService.elasticSerchTest(pageable);

        return ResponseEntity.ok(esBlogDTOS);
    }

}
