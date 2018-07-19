package pers.zhw.service;


import com.lly835.bestpay.model.PayResponse;
import pers.zhw.dto.OrderDTO;

public interface PayService {
    PayResponse create(OrderDTO orderDTO);
}
