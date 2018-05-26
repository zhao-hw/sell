package pers.zhw.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pers.zhw.dataobject.OrderMaster;

public interface OrderMasterRepository extends JpaRepository<OrderMaster,String>{
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
