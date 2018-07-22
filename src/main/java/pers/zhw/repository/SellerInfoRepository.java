package pers.zhw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.zhw.dataobject.SellerInfo;

public interface SellerInfoRepository extends JpaRepository<SellerInfo,Object>{
    SellerInfo findByOpenid(String openid);
}
