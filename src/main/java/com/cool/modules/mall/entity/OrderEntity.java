package com.cool.modules.mall.entity;

import com.cool.core.base.BaseEntity;
import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Table;
import com.tangzc.mybatisflex.autotable.annotation.ColumnDefine;
import com.tangzc.mybatisflex.autotable.annotation.UniIndex;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * 订单信息
 */
@Getter
@Setter
@Table(value = "mall_order", comment = "订单信息")
public class OrderEntity extends BaseEntity<OrderEntity> {

    @UniIndex
    @ColumnDefine(comment = "订单编号")
    private String orderNo;

    @ColumnDefine(comment = "订单状态 0-待付款 1-已支付 2-已发货 3-已完成 4-已取消 5-退款中", defaultValue = "0")
    private Integer status;

    @ColumnDefine(comment = "总金额")
    private BigDecimal totalAmount;

    @ColumnDefine(comment = "用户ID")
    private Long userId;

    @ColumnDefine(comment = "支付方式 0-微信 1-支付宝 2-银联", defaultValue = "0")
    private Integer payType;

    @ColumnDefine(comment = "收货地址ID")
    private Long addressId;

    @ColumnDefine(comment = "备注")
    private String remark;
}