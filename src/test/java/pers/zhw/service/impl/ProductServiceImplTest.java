package pers.zhw.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.zhw.dataobject.ProductInfo;
import pers.zhw.enums.ProductStatusEnum;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    ProductServiceImpl service;
    @Test
    public void findOne() throws Exception {
        ProductInfo productInfo = service.findOne("124");
        Assert.assertEquals("皮皮虾",productInfo.getProductName());
    }

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> productInfoList = service.findUpAll();
        Assert.assertEquals("皮蛋粥",productInfoList.get(0).getProductName());
    }

    @Test
    public void findAll() throws Exception {
        PageRequest request = new PageRequest(0,2);
        Page<ProductInfo> productInfoPage = service.findAll(request);
        System.out.println(productInfoPage.getTotalElements());
    }

    @Test
    public void save() throws Exception {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("124");
        productInfo.setProductName("皮皮虾");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好吃的虾");
        productInfo.setProductIcon("http://xxxx.jpg");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(2);
        ProductInfo result = service.save(productInfo);
        Assert.assertEquals("皮皮虾",result.getProductName());
    }

    @Test
    public void onSale(){
        ProductInfo productInfo = service.onSale("123");
        Assert.assertEquals("在架",productInfo.getProductStatusEnum().getMsg());
    }

    @Test
    public void offSale(){
        ProductInfo productInfo = service.offSale("123");
        Assert.assertEquals("下架",productInfo.getProductStatusEnum().getMsg());
    }

}