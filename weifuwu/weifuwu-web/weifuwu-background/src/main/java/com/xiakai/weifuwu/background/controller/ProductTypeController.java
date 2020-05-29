package com.xiakai.weifuwu.background.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xiakai.weifuwu.entity.TProductType;
import com.xiakai.weifuwu.api.product.IProductTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xiakai
 * @create 2020-05-19 13:27
 */
@RestController
@RequestMapping("/productType")
public class ProductTypeController {

    @Reference
    private IProductTypeService productTypeService;

    @GetMapping("/list")
    public List<TProductType> list() {
        return productTypeService.list();
    }

}
