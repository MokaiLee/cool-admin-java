package com.cool.modules.mall.service;

import com.cool.core.base.BaseService;
import com.cool.modules.mall.entity.CategoryEntity;
import java.util.List;
import java.util.Map;

/**
 * 商品分类服务接口
 */
public interface CategoryService extends BaseService<CategoryEntity> {
    List<Map<String, Object>> getCategoryWithCount();
}