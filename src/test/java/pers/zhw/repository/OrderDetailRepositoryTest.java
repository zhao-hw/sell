package pers.zhw.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.zhw.dataobject.OrderDetail;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {
    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest() throws Exception{
        OrderDetail orderDetil = new OrderDetail();
        orderDetil.setDetailId("123456789");
        orderDetil.setOrderId("111111");
        orderDetil.setProductId("126");
        orderDetil.setProductName("小米粥");
        orderDetil.setProductPrice(new BigDecimal(3.2));
        orderDetil.setProductIcon("http://xxxx.jpg");
        orderDetil.setProductQuantity(2);
        repository.save(orderDetil);
    }

    @Test
    public void findByOrderId() throws Exception {
        List<OrderDetail> result = repository.findByOrderId("111111");
        Assert.assertEquals("126",result.get(0).getProductId());
    }

}