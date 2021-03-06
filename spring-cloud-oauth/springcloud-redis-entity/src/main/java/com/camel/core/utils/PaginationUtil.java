package com.camel.core.utils;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class PaginationUtil {

    public static PageInfo<BasePaginationEntity> startPage(BasePaginationEntity entity, ISelect iSelect){
        return PageHelper.startPage(entity.getPageNum(), entity.getPageSize())
                .doSelectPageInfo(iSelect);
    }
}
