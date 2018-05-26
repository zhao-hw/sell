package pers.zhw.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pers.zhw.dataobject.ProductInfo;
import pers.zhw.dto.CartDTO;

import java.util.List;


public interface ProductService {

    ProductInfo findOne(String productId);

    /**
     * 查询已上架的商品
     * @return
     */
    List<ProductInfo> findUpAll();
    Page<ProductInfo> findAll(Pageable pageable);
    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);

    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);
}
