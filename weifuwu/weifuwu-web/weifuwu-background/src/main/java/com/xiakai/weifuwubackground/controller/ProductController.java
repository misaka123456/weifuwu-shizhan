package com.xiakai.weifuwubackground.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xiakai.weifuwu.entity.TProduct;
import com.xiakai.weifuwu.product.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author xiakai
 * @create 2020-05-19 17:38
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Reference
    private IProductService productService;

    @GetMapping("/list")
    public String list(Model model) {
        List<TProduct> list = productService.list();
        model.addAttribute("list", list);
        return "product/list";
    }
}
