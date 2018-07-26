package pers.zhw.dataobject.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.zhw.dataobject.ProductCategory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper mapper;

    @Test
    public void insertByMap() throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("category_name","不热销");
        map.put("category_type",101);
        int result = mapper.insertByMap(map);
        Assert.assertEquals(1,result);
    }

    @Test
    public void insertByObject() throws Exception {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryType(102);
        productCategory.setCategoryName("不热销");
        int result = mapper.insertByObject(productCategory);
        Assert.assertEquals(1,result);
    }

    @Test
    public void findByCategoryType() throws Exception {
        ProductCategory result = mapper.findByCategoryType(102);
        Assert.assertEquals(102,result.getCategoryType().intValue());
    }

    @Test
    public void findByCategoryName() throws Exception {
        ProductCategory result = mapper.findByCategoryName("不热销");
        Assert.assertEquals(102,result.getCategoryType().intValue());
    }

}