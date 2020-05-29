package com.xiakai.common.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author xiakai
 * @create 2020-05-25 16:07
 */
@Data
public class PageInfoBean<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    //当前页
    private int pageNum;
    //每页的数量
    private int pageSize;
//    //当前页的数量
//    private int size;

    //总记录数
    private long total;
    //总页数
    private int pages;
    //结果集
    private List<T> list;

    //导航页码数
    private int navigatePages;
    //所有导航页号
    private int[] navigatepageNums;

    private String keyWord;

    public void setNavigatePages (int navigatePages) {
        this.navigatePages = navigatePages;
        calcNavigatepageNums();
        // 计算到行业吗
    }

    /**
     * 计算导航页
     */
    private void calcNavigatepageNums() {
        //当总页数小于或等于导航页码数时
        if (pages <= navigatePages) {
            navigatepageNums = new int[pages];
            for (int i = 0; i < pages; i++) {
                navigatepageNums[i] = i + 1;
            }
        } else { //当总页数大于导航页码数时
            navigatepageNums = new int[navigatePages];
            int startNum = pageNum - navigatePages / 2;
            int endNum = pageNum + navigatePages / 2;

            if (startNum < 1) {
                startNum = 1;
                //(最前navigatePages页
                for (int i = 0; i < navigatePages; i++) {
                    navigatepageNums[i] = startNum++;
                }
            } else if (endNum > pages) {
                endNum = pages;
                //最后navigatePages页
                for (int i = navigatePages - 1; i >= 0; i--) {
                    navigatepageNums[i] = endNum--;
                }
            } else {
                //所有中间页
                for (int i = 0; i < navigatePages; i++) {
                    navigatepageNums[i] = startNum++;
                }
            }
        }
    }

}
