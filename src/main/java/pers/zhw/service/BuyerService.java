package pers.zhw.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pers.zhw.dto.OrderDTO;

public interface BuyerService {
    OrderDTO findOrderOne(String openid,String orderId);
    OrderDTO cancelOrder(String openid,String orderId);
    Page<OrderDTO> findList(Pageable pageable);
}
