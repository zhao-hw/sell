package pers.zhw.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.zhw.dataobject.OrderMaster;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID = "123abc";
    @Test
    public void saveTest() throws Exception{
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123456");
        orderMaster.setBuyerName("大伟");
        orderMaster.setBuyerPhone("12345678912");
        orderMaster.setBuyerAddress("郑州");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(2.2));
        OrderMaster result = repository.save(orderMaster);
        Assert.assertEquals("123456",result.getOrderId());
    }
    @Test
    public void findByBuyerOpenid() throws Exception {
        PageRequest request = new PageRequest(0,3);
        Page<OrderMaster> result = repository.findByBuyerOpenid(OPENID, request);
        Assert.assertNotNull(result);
    }

}