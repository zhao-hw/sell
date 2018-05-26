package pers.zhw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.zhw.dataobject.OrderDetail;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,String>{
    List<OrderDetail> findByOrderId(String orderId);
}
