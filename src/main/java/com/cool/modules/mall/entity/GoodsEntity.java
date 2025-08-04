package com.cool.modules.mall.entity;

import com.cool.core.base.BaseEntity;
import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Table;
import com.tangzc.mybatisflex.autotable.annotation.ColumnDefine;
import org.dromara.autotable.annotation.Index;
import lombok.Getter;
import lombok.Setter;

/**
 * 商品信息表
 */
@Getter
@Setter
@Table(value = "mall_goods", comment = "商品信息表")
public class GoodsEntity extends BaseEntity<GoodsEntity> {

    @ColumnDefine(comment = "图片")
    private String pic;

    @Index
    @ColumnDefine(comment = "名称")
    private String name;

    @ColumnDefine(comment = "价格")
    private Double price;

    @ColumnDefine(comment = "分类ID")
    private Long categoryId;

    @ColumnDefine(comment = "品牌")
    private String brand;

    @ColumnDefine(comment = "产地")
    private String origin;

    @ColumnDefine(comment = "状态 1=上架，0=下架", defaultValue = "1")
    private Integer status;

    @ColumnDefine(comment = "详情")
    private String detail;

    @ColumnDefine(comment = "排序")
    private Integer sort;
}