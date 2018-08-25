package pers.zhw.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.zhw.dataobject.ProductCategory;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductorCategoryRepositoryTest {
    @Autowired
    ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
        Optional<ProductCategory> productCategory = repository.findById(1);
        System.out.println(productCategory);
    }

    @Transactional
    @Test
    public void saveTest(){
        ProductCategory category = new ProductCategory("我喜欢",2);
        ProductCategory result = repository.save(category);
        Assert.assertNotNull(result);
    }

    @Test
    public void ProductCategoryRepositoryTest(){
        List<Integer> list = Arrays.asList(1,3,5,7);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }
}