package com.cool.modules.mall.service.impl;

import static com.cool.modules.mall.entity.table.OrderEntityTableDef.ORDER_ENTITY;

import com.cool.core.base.BaseServiceImpl;
import com.cool.modules.mall.entity.OrderEntity;
import com.cool.modules.mall.mapper.OrderMapper;
import com.cool.modules.mall.service.OrderService;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 订单信息Service实现类
 */
@Service
public class OrderServiceImpl extends BaseServiceImpl<OrderMapper, OrderEntity> implements
    OrderService {

}