package pers.zhw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.zhw.dataobject.ProductInfo;

import java.util.List;

public interface ProductInfoRepository extends JpaRepository<ProductInfo,String>{
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
