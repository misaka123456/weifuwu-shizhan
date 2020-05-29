package com.xiakai.weifuwu.search.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiakai.common.pojo.PageInfoBean;
import com.xiakai.common.pojo.ResultBean;
import com.xiakai.weifuwu.api.search.ISearchProductService;
import com.xiakai.weifuwu.entity.TProduct;
import com.xiakai.weifuwu.mapper.TProductMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author xiakai
 * @create 2020-05-25 09:20
 */
@Service
public class SearchProductServiceImpl implements ISearchProductService {

    @Autowired
    private TProductMapper productMapper;

    @Autowired
    private SolrClient solrClient;

    @Override
    public ResultBean initAllData() {
        List<TProduct> products = productMapper.list();

        for (TProduct product : products) {
           add(product);
        }
        try {
            solrClient.commit();
        } catch (SolrServerException | IOException e) {
            e.printStackTrace();
            // 记录日志
            return ResultBean.ERROR("solrClient提交失败", 500);
        }
        return ResultBean.SUCCESS("init all data is ok!");
    }

    @Override
    public void add(TProduct product) {
        try {
            addDocument(product);
            solrClient.commit();
        } catch (SolrServerException | IOException e) {
            e.printStackTrace();
        }
    }

    private void addDocument(TProduct product) throws IOException, SolrServerException {
        // product转换成document存入solr
        SolrInputDocument document = new SolrInputDocument();
        document.setField("id", product.getId());
        document.setField("product_name", product.getName());
        document.setField("product_images", product.getImage());
        document.setField("product_sale_point", product.getSalePoint());
        document.setField("product_price", product.getPrice());
        solrClient.add(document);
    }

    @Override
    public void deleteById(Long id) {
        try {
            solrClient.deleteById(String.valueOf(id));
            solrClient.commit();
        } catch (SolrServerException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PageInfoBean<TProduct> searchByKeyWord(String keyWord, Integer pageIndex, Integer pageSize) {

        PageInfoBean<TProduct> pageInfo = new PageInfoBean<>();

        List<TProduct> products = null;
        SolrQuery queryCondition = new SolrQuery();

        long totalCount = 0;

        if (!StringUtils.isAllEmpty(keyWord)) {
            queryCondition.setQuery("product_keywords:" + keyWord);
            // 设置高亮
            queryCondition.setHighlight(true);
            queryCondition.addHighlightField("product_name");
            queryCondition.setHighlightSimplePre("<font color='red'>");
            queryCondition.setHighlightSimplePost("</font>");
            queryCondition.addHighlightField("product_sale_point");
            queryCondition.setHighlightSimplePre("<font color='red'>");
            queryCondition.setHighlightSimplePost("</font>");

            // 增加分页
            queryCondition.setStart((pageIndex - 1) * pageSize);
            queryCondition.setRows(pageSize);

            try {
                QueryResponse response = solrClient.query(queryCondition);
                SolrDocumentList list = response.getResults();
                totalCount = list.getNumFound();

                // 获取高亮信息
                Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();

                products = new ArrayList<>(list.size());
                for (SolrDocument document : list) {
                    TProduct product = new TProduct();
                    product.setId(Long.parseLong(document.getFieldValue("id").toString()));
                    product.setName(document.getFieldValue("product_name").toString());
                    product.setImage(document.getFieldValue("product_images").toString());
                    product.setSalePoint(document.getFieldValue("product_sale_point").toString());
                    product.setPrice(Long.parseLong(document.getFieldValue("product_price").toString()));

                    // 获取具体product商品名称的高亮信息
                    Map<String, List<String>> map = highlighting.get(document.getFieldValue("id").toString());
                    // 获取某个字段高亮信息
                    List<String> productNameHigh = map.get("product_name");
                    if (productNameHigh != null && productNameHigh.size() > 0) {
                        product.setName(productNameHigh.get(0));
                    }
                    List<String> productSalePointHigh = map.get("product_sale_point");
                    if (productSalePointHigh != null &&productSalePointHigh.size() > 0) {
                        product.setSalePoint(productSalePointHigh.get(0));
                    }
                    products.add(product);
                }
                solrClient.commit();
            } catch (SolrServerException | IOException e) {
                e.printStackTrace();
            }
        }

        pageInfo.setList(products);
        pageInfo.setPageNum(pageIndex);
        pageInfo.setPageSize(pageSize);
        pageInfo.setTotal(totalCount);
        pageInfo.setPages((int) ((totalCount / pageSize) + (totalCount % pageSize == 0 ? 0 : 1)));
        pageInfo.setNavigatePages(Math.min(pageInfo.getPages(), 7));
        pageInfo.setKeyWord(keyWord);

        return pageInfo;
    }


}
