package pers.zhw.dto;

import lombok.Data;

@Data
public class CartDTO {

    /** 商品id.*/
    private String productId;

    /** 数量.*/
    private Integer productQuantiany;

    public CartDTO(String productId, Integer productQuantiany) {
        this.productId = productId;
        this.productQuantiany = productQuantiany;
    }
    public CartDTO(){}
}
