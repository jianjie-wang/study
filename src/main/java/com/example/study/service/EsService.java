package com.example.study.service;

import com.example.study.repository.EsBLogRepository;
import com.example.study.service.DTO.EsBlogDTO;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: study
 * @description:
 * @author: WangJJ
 * @create: 2020-09-16 15:40
 **/
@Service
public class EsService {

    private final EsBLogRepository esBLogRepository;

    public EsService(EsBLogRepository esBLogRepository) {
        this.esBLogRepository = esBLogRepository;
    }


    public Page<EsBlogDTO> elasticSerchTest(Pageable pageable) {
        //1.创建QueryBuilder(即设置查询条件)这儿创建的是组合查询(也叫多条件查询)
        /*组合查询BoolQueryBuilder
         * must(QueryBuilders)   :AND
         * mustNot(QueryBuilders):NOT
         * should:               :OR
         */
        BoolQueryBuilder builder = QueryBuilders.boolQuery();

        //设置模糊搜索,博客的简诉中有学习两个字
        builder.must(QueryBuilders.fuzzyQuery("sumary", "学习"));
        //设置要查询博客的标题中含有关键字
        builder.must(new QueryStringQueryBuilder("man").field("springdemo"));

        //按照创建时间降序
        FieldSortBuilder sort = SortBuilders.fieldSort("createdTimeTimestamp").order(SortOrder.DESC);

        //2.构建查询
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();

        //分别将搜索条件,分页,排序设置到构建中
        nativeSearchQueryBuilder.withQuery(builder);
        nativeSearchQueryBuilder.withPageable(pageable);
        nativeSearchQueryBuilder.withSort(sort);
        //生产NativeSearchQuery
        NativeSearchQuery query = nativeSearchQueryBuilder.build();

        //3.执行方法1
        Page<EsBlogDTO> page = esBLogRepository.search(query);
        //执行方法2：注意，这儿执行的时候还有个方法那就是使用elasticsearchTemplate
        //执行方法2的时候需要加上注解
//        @Autowired
//        private ElasticsearchTemplate elasticsearchTemplate;
//        List<EsBlogDTO> blogList = elasticsearchTemplate.queryForList(query, EsBlogDTO.class);

        //4.获取总条数(用于前端分页)
        int total = (int) page.getTotalElements();

        //5.获取查询到的数据内容（返回给前端）
        List<EsBlogDTO> content = page.getContent();

        return page;
    }

}
