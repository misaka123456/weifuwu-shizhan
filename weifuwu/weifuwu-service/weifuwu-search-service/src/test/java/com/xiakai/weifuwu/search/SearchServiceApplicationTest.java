package com.xiakai.weifuwu.search;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * @author xiakai
 * @create 2020-05-24 22:34
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class SearchServiceApplicationTest {

    @Autowired
    private SolrClient solrClient;

    /**
     * 没有就添加，有就修改
     */
    @Test
    public void addOrUpdateTest() throws IOException, SolrServerException {
        // solr里面的操作记录
        SolrInputDocument document = new SolrInputDocument();
        // 需要唯一的标识
        document.setField("id", 101);
        document.setField("product_name", "张学友香港红馆演唱会门票,hahaha,我是煞笔，你死奥利给");
        document.setField("product_price", "100000");
        document.setField("product_sale_point", "歌神，史上最强");
        document.setField("product_images", "暂无");

        solrClient.add(document);
    }

    @Test
    public void deleteTest() throws IOException, SolrServerException {

        // 根据id删除
        solrClient.deleteById("10");

        // 匹配查询
        solrClient.deleteByQuery("product_name:刘德华张学友");

    }
    
    
    @Test
    public void selectAllTest() throws IOException, SolrServerException {
        // 组装查询条件
        SolrQuery queryCondition = new SolrQuery();
        queryCondition.setQuery("*:*");
        // 执行查询
        QueryResponse response = solrClient.query(queryCondition);
        SolrDocumentList results = response.getResults();
        for (SolrDocument document : results) {
//            System.out.println(document);
            System.out.println(document.get("id"));
            System.out.println(document.get("product_name"));
            System.out.println(document.get("product_sale_point"));
            System.out.println(document.get("product_keywords"));
        }
    }


    @Test
    public void selectByNameTest() throws IOException, SolrServerException {
        // 组装查询条件
        SolrQuery queryCondition = new SolrQuery();
        queryCondition.setQuery("product_name:张学友刘德华同台演出");
        // 执行查询
        QueryResponse response = solrClient.query(queryCondition);
        SolrDocumentList results = response.getResults();
        for (SolrDocument document : results) {
//            System.out.println(document);
            System.out.println(document.get("id"));
            System.out.println(document.get("product_name"));
            System.out.println(document.get("product_sale_point"));
            System.out.println(document.get("product_keywords"));
        }
    }


    @After
    public void after() throws IOException, SolrServerException {
        // 提交
        solrClient.commit();
    }



}
