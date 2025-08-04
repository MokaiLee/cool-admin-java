package com.cool.modules.mall.service.impl;

import com.cool.core.base.BaseServiceImpl;
import com.cool.modules.mall.entity.CategoryEntity;
import com.cool.modules.mall.mapper.CategoryMapper;
import com.cool.modules.mall.service.CategoryService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import static com.cool.modules.mall.entity.table.CategoryEntityTableDef.CATEGORY_ENTITY;
import static com.cool.modules.mall.entity.table.GoodsEntityTableDef.GOODS_ENTITY;

import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.row.Row;
import java.util.ArrayList;

/**
 * 商品分类服务实现类
 */
@Service
public class CategoryServiceImpl extends BaseServiceImpl<CategoryMapper, CategoryEntity> implements CategoryService {

    @Override
    public List<Map<String, Object>> getCategoryWithCount() {
        QueryWrapper queryWrapper = QueryWrapper.create()
            .select(CATEGORY_ENTITY.CATEGORY_NAME, CATEGORY_ENTITY.ID, com.mybatisflex.core.query.QueryMethods.count(GOODS_ENTITY.ID).as("goodsCount"))
            .from(CATEGORY_ENTITY)
            .leftJoin(GOODS_ENTITY).on(CATEGORY_ENTITY.ID.eq(GOODS_ENTITY.CATEGORY_ID))
            .groupBy(CATEGORY_ENTITY.ID);

        List<Row> rows = mapper.selectListByQueryAs(queryWrapper, Row.class);
        List<Map<String, Object>> result = new ArrayList<>();
        for (Row row : rows) {
            result.add(row.toCamelKeysMap());
        }
        return result;
    }
}