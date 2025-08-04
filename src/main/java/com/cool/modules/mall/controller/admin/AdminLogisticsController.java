package com.cool.modules.mall.controller.admin;

import static com.cool.modules.mall.entity.table.LogisticsEntityTableDef.LOGISTICS_ENTITY;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONObject;
import com.cool.core.annotation.CoolRestController;
import com.cool.core.base.BaseController;
import com.cool.core.request.R;
import com.cool.modules.mall.entity.LogisticsEntity;
import com.cool.modules.mall.service.LogisticsService;
import com.mybatisflex.core.query.QueryWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

/**
 * 物流管理
 */
@Tag(name = "物流管理", description = "管理物流信息")
@CoolRestController(api = {"add", "delete", "update", "info", "page"})
public class AdminLogisticsController extends
    BaseController<LogisticsService, LogisticsEntity> {

    @Override
    protected void init(HttpServletRequest request, JSONObject requestParams) {
        setPageOption(
            createOp()
                .fieldEq(LOGISTICS_ENTITY.COMPANY)
                .fieldEq(LOGISTICS_ENTITY.STATUS)
                .keyWordLikeFields(LOGISTICS_ENTITY.TRACKING_NO)
                .queryWrapper(QueryWrapper.create().between(LogisticsEntity::getDeliveryTime, requestParams.getDate("startTime"), requestParams.getDate("endTime")))
                .queryWrapper(QueryWrapper.create().orderBy(LOGISTICS_ENTITY.DELIVERY_TIME.desc())));
    }

    @Operation(summary = "物流统计")
    @GetMapping("/statistics")
    public R statistics(@RequestAttribute JSONObject requestParams) {
        // TODO: 物流统计逻辑
        return R.ok();
    }
}