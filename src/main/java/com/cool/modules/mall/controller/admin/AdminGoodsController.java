package com.cool.modules.mall.controller.admin;

import com.cool.core.annotation.CoolRestController;
import com.cool.core.base.BaseController;
import com.cool.modules.mall.entity.GoodsEntity;
import com.cool.modules.mall.service.GoodsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.hutool.json.JSONObject;
import jakarta.servlet.http.HttpServletRequest;
import static com.cool.modules.mall.entity.table.GoodsEntityTableDef.GOODS_ENTITY;

/**
 * 商品信息管理
 */
@CoolRestController(api = {"add", "delete", "update", "info", "page"})
@Tag(name = "商品信息", description = "商品信息")
public class AdminGoodsController extends BaseController<GoodsService, GoodsEntity> {

    @Override
    protected void init(HttpServletRequest request, JSONObject requestParams) {
        setPageOption(createOp()
            .keyWordLikeFields(GOODS_ENTITY.NAME)
            .fieldEq(GOODS_ENTITY.CATEGORY_ID, GOODS_ENTITY.STATUS));
    }
}