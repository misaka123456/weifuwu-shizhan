package com.xiakai.weifuwu.background.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.xiakai.common.pojo.ResultBean;
import com.xiakai.weifuwu.api.IProductItemService;
import com.xiakai.weifuwu.api.search.ISearchProductService;
import com.xiakai.weifuwu.entity.TProduct;
import com.xiakai.weifuwu.api.product.IProductService;
import com.xiakai.weifuwu.vo.ProductVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @Reference
    private ISearchProductService searchService;

    @Reference
    private IProductItemService itemService;

    @GetMapping("/list")
    public String list(Model model) {
        List<TProduct> list = productService.list();
        model.addAttribute("list", list);
        return "product/list";
    }

    @GetMapping("/page/{index}/{size}")
    public String page(Model model,
                       @PathVariable("index") Integer index,
                       @PathVariable("size") Integer size) {
        PageInfo<TProduct> pageInfo = productService.page(index, size);
        model.addAttribute("pageInfo", pageInfo);
        return "product/page";
    }

    @PostMapping("/add")
    public String add(ProductVO productVO) {
        Long productId = productService.add(productVO);
        TProduct product = productVO.getProduct();
        product.setId(productId);
        // 添加到搜索服务器
        searchService.add(product);

        ResultBean htmlById = itemService.createHtmlById(productId);
        System.out.println(htmlById.getStatusCode());

        return "redirect:/product/page/1/7";
    }

    @DeleteMapping("/deleteById")
    @ResponseBody
    public String delete(@RequestParam Long id) {
        productService.deleteByPrimaryKey(id);
        // 删除搜索服务器中的数据
        searchService.deleteById(id);
        return "success";
    }

}
