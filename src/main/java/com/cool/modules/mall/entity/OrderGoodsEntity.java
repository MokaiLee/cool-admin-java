package com.cool.modules.mall.entity;

import com.cool.core.base.BaseEntity;
import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Table;
import com.tangzc.mybatisflex.autotable.annotation.ColumnDefine;
import org.dromara.autotable.annotation.Index;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 订单商品信息
 */
@Getter
@Setter
@Table(value = "mall_order_goods", comment = "订单商品信息")
public class OrderGoodsEntity extends BaseEntity<OrderGoodsEntity> {

    @Index
    @ColumnDefine(comment = "订单ID")
    private Long orderId;

    @Index
    @ColumnDefine(comment = "商品ID")
    private Long goodsId;

    @ColumnDefine(comment = "数量")
    private Integer quantity;

    @ColumnDefine(comment = "单价")
    private BigDecimal price;

    @ColumnDefine(comment = "总价")
    private BigDecimal totalPrice;
}