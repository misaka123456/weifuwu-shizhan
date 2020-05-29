package com.xiakai.weifuwu.search.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xiakai.common.pojo.PageInfoBean;
import com.xiakai.common.pojo.ResultBean;
import com.xiakai.weifuwu.api.search.ISearchProductService;
import com.xiakai.weifuwu.entity.TProduct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author xiakai
 * @create 2020-05-25 09:01
 */
@Controller
@RequestMapping("/search")
public class SearchProductController {


    @Reference
    private ISearchProductService searchService;

    @RequestMapping("/initAllData")
    @ResponseBody
    public ResultBean initAllData() {
        return searchService.initAllData();
    }

    @RequestMapping("/searchByKeyWord")
    public String searchByKeyWord(@RequestParam String keyWord,
                                  @RequestParam(defaultValue = "1") Integer pageIndex,
                                  @RequestParam(defaultValue = "5") Integer pageSize, Model model) {
        PageInfoBean<TProduct> pageInfo = searchService.searchByKeyWord(keyWord, pageIndex, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        return "result";
    }


}
