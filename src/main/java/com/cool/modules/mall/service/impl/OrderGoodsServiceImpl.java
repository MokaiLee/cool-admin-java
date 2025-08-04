package com.cool.modules.mall.service.impl;

import com.cool.core.base.BaseServiceImpl;
import com.cool.modules.mall.entity.OrderGoodsEntity;
import com.cool.modules.mall.mapper.OrderGoodsMapper;
import com.cool.modules.mall.service.OrderGoodsService;
import org.springframework.stereotype.Service;

/**
 * 订单商品信息Service实现类
 */
@Service
public class OrderGoodsServiceImpl extends
    BaseServiceImpl<OrderGoodsMapper, OrderGoodsEntity> implements OrderGoodsService {

}