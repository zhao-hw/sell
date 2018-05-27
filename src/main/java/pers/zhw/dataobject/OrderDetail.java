package pers.zhw.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
public class OrderDetail {

    /** 详情id.*/
    @Id
    private String detailId;

    /** 订单id.*/
    private String orderId;

    /** 商品id.*/
    private String productId;

    /** 商品名称.*/
    private String productName;

    /** 商品价格.*/
    private BigDecimal productPrice;

    /** 商品数量.*/
    private Integer productQuantity;

    /** 商品小图.*/
    private String productIcon;

    @Override
    public String toString() {
        return "OrderDetail{" + "\n" + "\t" + "\t" +
                "detailId='" + detailId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productQuantity=" + productQuantity +
                ", productIcon='" + productIcon + '\'' +
                '}';
    }
}
