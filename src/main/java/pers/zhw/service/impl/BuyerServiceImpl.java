package pers.zhw.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pers.zhw.dto.OrderDTO;
import pers.zhw.enums.ResultEnum;
import pers.zhw.exception.SellException;
import pers.zhw.service.BuyerService;
import pers.zhw.service.OrderService;

@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        return checkOrderOwner(openid,orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid,orderId);
        if (orderDTO == null){
            log.error("【取消订单】查不到该订单，orderId={},",orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }

    @Override
    public Page<OrderDTO> findList(Pageable pageable) {

        return null;
    }

    private OrderDTO checkOrderOwner(String openid,String orderId){
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null){
            return null;
        }
        //判断订单是否是自己的
        if (!orderDTO.getBuyerOpenid().equals(openid)){
            log.error("【查询订单】订单的openid不一致，openid={}，orderDTO={}",openid,orderDTO);
            //throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
