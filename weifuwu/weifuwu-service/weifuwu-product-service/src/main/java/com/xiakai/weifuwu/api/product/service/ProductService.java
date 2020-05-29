package com.xiakai.weifuwu.api.product.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiakai.common.base.BaseServiceImpl;
import com.xiakai.common.base.IBaseMapper;
import com.xiakai.weifuwu.entity.TProduct;
import com.xiakai.weifuwu.entity.TProductDesc;
import com.xiakai.weifuwu.mapper.TProductDescMapper;
import com.xiakai.weifuwu.mapper.TProductMapper;
import com.xiakai.weifuwu.api.product.IProductService;
import com.xiakai.weifuwu.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @author xiakai
 * @create 2020-05-19 19:03
 */
@Service
public class ProductService extends BaseServiceImpl<TProduct> implements IProductService {

    @Autowired
    private TProductMapper productMapper;

    @Autowired
    private TProductDescMapper productDescMapper;

    @Override
    public IBaseMapper<TProduct> getBaseMapper() {
        return productMapper;
    }

    @Override
    public PageInfo<TProduct> page(Integer index, Integer size) {

        PageHelper.startPage(index, size);
        List<TProduct> list = productMapper.list();
        // navigatePages : 分页栏展示数
        PageInfo<TProduct> pageInfo = new PageInfo<>(list, 8);

        return pageInfo;
    }

    @Override
    public Long add(ProductVO productVO) {
        TProduct product = productVO.getProduct();

        // 常规属性
        product.setFlag(true);
        product.setCreateTime(new Date());
        product.setUpdateTime(new Date());
        product.setCreateUser(1L);
        product.setUpdateUser(product.getCreateUser());

        productMapper.insertSelective(product);

        TProductDesc productDesc = new TProductDesc();
        productDesc.setProductId(product.getId());
        productDesc.setProductDesc(productVO.getProductDesc() == null ? "" : productVO.getProductDesc());
        productDescMapper.insertSelective(productDesc);
        // 返回商品id
        return product.getId();
    }

    @Override
    public int deleteByPrimaryKey(Long key) {
        productDescMapper.deleteByProductId(key);
        return super.deleteByPrimaryKey(key);
    }
}
