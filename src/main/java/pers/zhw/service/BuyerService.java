package pers.zhw.service;

import pers.zhw.dto.OrderDTO;

public interface BuyerService {
    OrderDTO findOrderOne(String openid,String orderId);
    OrderDTO cancelOrder(String openid,String orderId);
}
