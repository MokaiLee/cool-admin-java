package com.cool.modules.mall.controller.admin;

import com.cool.core.annotation.CoolRestController;
import com.cool.core.base.BaseController;
import com.cool.modules.mall.entity.EvaluateEntity;
import com.cool.modules.mall.service.EvaluateService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.hutool.json.JSONObject;
import jakarta.servlet.http.HttpServletRequest;

/**
 * 商品评价管理
 */
@CoolRestController(api = {"delete", "page", "info"})
@Tag(name = "商品评价", description = "商品评价")
public class AdminEvaluateController extends BaseController<EvaluateService, EvaluateEntity> {

    @Override
    protected void init(HttpServletRequest request, JSONObject requestParams) {
        setPageOption(createOp());
    }
}