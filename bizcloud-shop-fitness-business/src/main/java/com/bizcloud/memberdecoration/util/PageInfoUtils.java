package com.bizcloud.memberdecoration.util;

import com.bizcloud.framework.exception.BizException;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fuxueyong on 2017/3/24.
 */
public class PageInfoUtils {

    public static void clonePageInfo(PageInfo source, PageInfo target) throws BizException {
        if (source == null || target == null){
            return;
        }
        target.setEndRow(source.getEndRow());
        target.setFirstPage(source.getFirstPage());
        target.setHasNextPage(source.isHasNextPage());
        target.setHasPreviousPage(source.isHasPreviousPage());
        target.setIsFirstPage(source.isIsFirstPage());
        target.setIsLastPage(source.isIsLastPage());
        target.setLastPage(source.getLastPage());
        target.setNavigatepageNums(source.getNavigatepageNums());
        target.setNextPage(source.getNextPage());
        target.setPageNum(source.getPageNum());
        target.setNavigatePages(source.getNavigatePages());
        target.setPages(source.getPages());
        target.setPageSize(source.getPageSize());
        target.setPrePage(source.getPrePage());
        target.setSize(source.getSize());
        target.setStartRow(source.getStartRow());
        target.setTotal(source.getTotal());
    }
}
