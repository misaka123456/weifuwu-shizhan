package com.xiakai.weifuwu.index.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xiakai.weifuwu.entity.TProductType;
import com.xiakai.weifuwu.api.product.IProductTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author xiakai
 * @create 2020-05-24 10:54
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @Reference
    private IProductTypeService productTypeService;

    @RequestMapping("/show")
    public String showIndex(Model model) {
        List<TProductType> list = productTypeService.list();
        model.addAttribute("list", list);
        return "index";

    }

}
