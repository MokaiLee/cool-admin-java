package com.cool.modules.mall.entity;

import com.cool.core.base.BaseEntity;
import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Table;
import com.tangzc.mybatisflex.autotable.annotation.ColumnDefine;
import org.dromara.autotable.annotation.Index;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * 物流信息
 */
@Getter
@Setter
@Table(value = "mall_logistics", comment = "物流信息")
public class LogisticsEntity extends BaseEntity<LogisticsEntity> {

    @ColumnDefine(comment = "物流公司")
    private String company;

    @Index
    @ColumnDefine(comment = "运单号")
    private String trackingNo;

    @ColumnDefine(comment = "物流状态 0-运输中 1-已签收 2-异常", defaultValue = "0")
    private Integer status;

    @ColumnDefine(comment = "发货时间")
    private Date deliveryTime;

    @ColumnDefine(comment = "用户ID")
    private Long userId;

    @ColumnDefine(comment = "收货地址ID")
    private Long addressId;

    @ColumnDefine(comment = "备注")
    private String remark;

    @ColumnDefine(comment = "订单ID")
    private Long orderId;
}