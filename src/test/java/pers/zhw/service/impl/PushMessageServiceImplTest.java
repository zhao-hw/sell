package pers.zhw.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.zhw.dto.OrderDTO;
import pers.zhw.service.OrderService;
import pers.zhw.service.PushMessageService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PushMessageServiceImplTest {

    @Autowired
    private PushMessageService pushMessageService;

    @Autowired
    private OrderService orderService;
    @Test
    public void orderStatus() throws Exception {
        OrderDTO orderDTO = orderService.findOne("1532157720317917883");
        pushMessageService.orderStatus(orderDTO);
    }

}