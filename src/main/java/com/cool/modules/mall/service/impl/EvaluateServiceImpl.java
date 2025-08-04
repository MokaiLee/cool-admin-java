package com.cool.modules.mall.service.impl;

import com.cool.core.base.BaseServiceImpl;
import com.cool.modules.mall.entity.EvaluateEntity;
import com.cool.modules.mall.mapper.EvaluateMapper;
import com.cool.modules.mall.service.EvaluateService;
import org.springframework.stereotype.Service;
import cn.hutool.json.JSONObject;
import com.cool.core.exception.CoolPreconditions;
import com.cool.core.util.CoolSecurityUtil;
import static com.cool.modules.mall.entity.table.EvaluateEntityTableDef.EVALUATE_ENTITY;
import com.mybatisflex.core.query.QueryWrapper;

/**
 * 商品评价服务实现类
 */
@Service
public class EvaluateServiceImpl extends BaseServiceImpl<EvaluateMapper, EvaluateEntity> implements EvaluateService {

    @Override
    public Long submit(JSONObject requestParams, EvaluateEntity entity) {
        Long userId = CoolSecurityUtil.getCurrentUserId();
        entity.setUserId(userId);

        QueryWrapper queryWrapper = QueryWrapper.create()
            .where(EVALUATE_ENTITY.USER_ID.eq(userId))
            .and(EVALUATE_ENTITY.GOODS_ID.eq(entity.getGoodsId()));

        if (mapper.selectCountByQuery(queryWrapper) > 0) {
            CoolPreconditions.check(true, "您已评价过该商品，不能重复评价");
        }

        super.add(entity);
        return entity.getId();
    }
}