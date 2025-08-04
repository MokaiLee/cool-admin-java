package com.cool.modules.mall.controller.app;

import com.cool.core.annotation.CoolRestController;
import com.cool.core.base.BaseController;
import com.cool.core.request.R;
import com.cool.modules.mall.entity.EvaluateEntity;
import com.cool.modules.mall.service.EvaluateService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.v3.oas.annotations.Operation;
import cn.hutool.json.JSONObject;

import static com.cool.modules.mall.entity.table.EvaluateEntityTableDef.EVALUATE_ENTITY;

/**
 * APP商品评价
 */
@CoolRestController
@Tag(name = "APP商品评价", description = "APP商品评价")
public class AppEvaluateController extends BaseController<EvaluateService, EvaluateEntity> {

    @Operation(summary = "提交评价")
    @PostMapping("/submit")
    public R submit(@RequestAttribute JSONObject requestParams, EvaluateEntity entity) {
        return R.ok(service.submit(requestParams, entity));
    }

    @Override
    protected void init(HttpServletRequest request, JSONObject requestParams) {
        setPageOption(createOp()
                .keyWordLikeFields(EVALUATE_ENTITY.CONTENT)
                .fieldEq(EVALUATE_ENTITY.GOODS_ID, EVALUATE_ENTITY.USER_ID));
    }
}