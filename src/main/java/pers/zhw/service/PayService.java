package pers.zhw.service;

import pers.zhw.dto.OrderDTO;

public interface PayService {
    void create(OrderDTO orderDTO);
}
