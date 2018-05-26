package pers.zhw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.zhw.dataobject.ProductCategory;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer>{
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
