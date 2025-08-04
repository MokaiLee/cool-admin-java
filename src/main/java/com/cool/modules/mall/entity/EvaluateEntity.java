package com.cool.modules.mall.entity;

import com.cool.core.base.BaseEntity;
import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Table;
import com.tangzc.mybatisflex.autotable.annotation.ColumnDefine;
import com.tangzc.mybatisflex.autotable.annotation.UniIndex;
import lombok.Getter;
import lombok.Setter;

/**
 * 商品评价表
 */
@Getter
@Setter
@Table(value = "mall_evaluate", comment = "商品评价表")
public class EvaluateEntity extends BaseEntity<EvaluateEntity> {

    @ColumnDefine(comment = "用户ID")
    private Long userId;

    @ColumnDefine(comment = "内容")
    private String content;

    @ColumnDefine(comment = "评分（1-5）")
    private Integer score;

    @UniIndex
    @ColumnDefine(comment = "商品ID")
    private Long goodsId;
}