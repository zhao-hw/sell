package pers.zhw.form;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
@Data
public class ProductForm {
    private String productId;
    /** 名字. */
    @NotNull
    private String productName;
    /** 单价. */
    @NotNull
    private BigDecimal productPrice;
    /** 库存. */
    @NotNull
    private Integer productStock;
    /** 描述. */
    @NotNull
    private String productDescription;
    /** 小图. */
    private String productIcon;
    /** 类目编号. */
    @NotNull
    private Integer categoryType;
}
