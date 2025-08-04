package com.cool.modules.mall.service;

import com.cool.core.base.BaseService;
import com.cool.modules.mall.entity.EvaluateEntity;
import cn.hutool.json.JSONObject;

/**
 * 商品评价服务接口
 */
public interface EvaluateService extends BaseService<EvaluateEntity> {
    Long submit(JSONObject requestParams, EvaluateEntity entity);
}