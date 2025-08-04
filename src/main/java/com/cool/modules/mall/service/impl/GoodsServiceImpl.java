package com.cool.modules.mall.service.impl;

import com.cool.core.base.BaseServiceImpl;
import com.cool.modules.mall.entity.GoodsEntity;
import com.cool.modules.mall.mapper.GoodsMapper;
import com.cool.modules.mall.service.GoodsService;
import org.springframework.stereotype.Service;

/**
 * 商品信息服务实现类
 */
@Service
public class GoodsServiceImpl extends BaseServiceImpl<GoodsMapper, GoodsEntity> implements GoodsService {
}