package com.cool.modules.mall.entity;

import com.cool.core.base.BaseEntity;
import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Table;
import com.tangzc.mybatisflex.autotable.annotation.ColumnDefine;
import org.dromara.autotable.annotation.Index;
import lombok.Getter;
import lombok.Setter;

/**
 * 商品分类表
 */
@Getter
@Setter
@Table(value = "mall_category", comment = "商品分类表")
public class CategoryEntity extends BaseEntity<CategoryEntity> {

    @ColumnDefine(comment = "图片")
    private String pic;

    @Index
    @ColumnDefine(comment = "分类名称")
    private String categoryName;

    @ColumnDefine(comment = "父类ID")
    private Long parentId;

    @ColumnDefine(comment = "排序")
    private Integer sort;
}