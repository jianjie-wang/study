package com.example.study.repository;


import com.example.study.service.DTO.EsBlogDTO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsBLogRepository  extends ElasticsearchRepository<EsBlogDTO,String> {


}
