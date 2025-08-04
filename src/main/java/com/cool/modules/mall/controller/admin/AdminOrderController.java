package com.cool.modules.mall.controller.admin;

import static com.cool.modules.mall.entity.table.OrderEntityTableDef.ORDER_ENTITY;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONObject;
import com.cool.core.annotation.CoolRestController;
import com.cool.core.base.BaseController;
import com.cool.core.request.R;
import com.cool.modules.mall.entity.OrderEntity;
import com.cool.modules.mall.service.OrderService;
import com.mybatisflex.core.query.QueryWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

/**
 * 订单管理
 */
@Tag(name = "订单管理", description = "管理订单信息")
@CoolRestController(api = {"add", "delete", "update", "info", "page"})
public class AdminOrderController extends BaseController<OrderService, OrderEntity> {

    @Override
    protected void init(HttpServletRequest request, JSONObject requestParams) {
        setPageOption(
            createOp()
                .fieldEq(ORDER_ENTITY.STATUS,ORDER_ENTITY.PAY_TYPE)
                .keyWordLikeFields(ORDER_ENTITY.ORDER_NO, ORDER_ENTITY.USER_ID)
                .queryWrapper(
                        QueryWrapper.create().between(OrderEntity::getCreateTime, requestParams.getDate("startTime"), requestParams.getDate("endTime"))
                        .orderBy(ORDER_ENTITY.CREATE_TIME.desc())
                )
        );
    }

    @Operation(summary = "订单统计")
    @GetMapping("/statistics")
    public R statistics(@RequestAttribute JSONObject requestParams) {
        // TODO: 订单统计逻辑
        return R.ok();
    }
}