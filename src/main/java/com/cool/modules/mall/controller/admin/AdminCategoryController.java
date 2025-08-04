package com.cool.modules.mall.controller.admin;

import com.cool.core.annotation.CoolRestController;
import com.cool.core.base.BaseController;
import com.cool.modules.mall.entity.CategoryEntity;
import com.cool.modules.mall.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cool.core.request.R;
import cn.hutool.json.JSONObject;
import jakarta.servlet.http.HttpServletRequest;
import static com.cool.modules.mall.entity.table.CategoryEntityTableDef.CATEGORY_ENTITY;

/**
 * 商品分类管理
 */
@Tag(name = "商品分类", description = "商品分类")
@CoolRestController(api = {"add", "delete", "update", "info", "page", "list"})
public class AdminCategoryController extends BaseController<CategoryService, CategoryEntity> {

    @Override
    protected void init(HttpServletRequest request, JSONObject requestParams) {
        setPageOption(createOp()
            .keyWordLikeFields(CATEGORY_ENTITY.CATEGORY_NAME)
            .fieldEq(CATEGORY_ENTITY.PARENT_ID));
    }

    @GetMapping("/categoryWithCount")
    public R categoryWithCount() {
        return R.ok(service.getCategoryWithCount());
    }
}