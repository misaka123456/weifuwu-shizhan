package com.xiakai.weifuwu.item.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.xiakai.common.pojo.ResultBean;
import com.xiakai.weifuwu.api.IProductItemService;
import com.xiakai.weifuwu.entity.TProduct;
import com.xiakai.weifuwu.mapper.TProductMapper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;

/**
 * @author xiakai
 * @create 2020-05-26 16:16
 */
@Service
public class ProductItemService implements IProductItemService {

    @Autowired
    private TProductMapper productMapper;

    @Autowired
    private Configuration configuration;

    private static int coreSize = Runtime.getRuntime().availableProcessors();

    private static ExecutorService pool = new ThreadPoolExecutor(coreSize, coreSize * 2, 0L, TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(100));

    @Value("${html.locations}")
    private String htmlLocations;

    @Override
    public ResultBean createHtmlById(Long productId) {
        //根据id获取数据
        TProduct product = productMapper.selectByPrimaryKey(productId);

        // 数据结合模版生成静态页
        try {
            Template template = configuration.getTemplate("item.ftl");
            Map<String, Object> data = new HashMap<>();
            data.put("product", product);
            FileWriter writer = new FileWriter(htmlLocations + "product-" + productId + ".html");
            template.process(data, writer);
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
            return ResultBean.ERROR("cuole", 500);
        }

        return ResultBean.SUCCESS("this is ok");
    }

    /**
     * 批量生成静态页
     */
    @Override
    public ResultBean batchCreateHtml(List<Long> idList) {
        List<Future<Boolean>> list = new ArrayList<>(idList.size());
        for (Long id : idList) {
            Future<Boolean> future = pool.submit(() -> {
                createHtmlById(id);
                return true;
            });
            list.add(future);
        }

        for (Future<Boolean> future : list) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        return ResultBean.SUCCESS("it is ok");
    }

    public ResultBean updateHtml(TProduct product) {


        return ResultBean.SUCCESS("it is ok");


    }



}
