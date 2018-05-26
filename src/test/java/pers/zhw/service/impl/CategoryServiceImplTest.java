package pers.zhw.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.zhw.dataobject.ProductCategory;
import pers.zhw.service.CategoryService;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne() throws Exception {
        ProductCategory result = categoryService.findOne(4);
        Assert.assertEquals("third",result.getCategoryName());
    }

    @Test
    public void findAll() throws Exception {
        List<ProductCategory> list = categoryService.findAll();
        Assert.assertEquals(5,list.size());
    }

    @Test
    public void finByCategoryTypeIn() throws Exception {
        List<ProductCategory> list = categoryService.finByCategoryTypeIn(Arrays.asList(1, 2, 3));
        Assert.assertEquals(3,list.size());
    }

    @Test
    @Transactional
    public void save() throws Exception {
        ProductCategory result = categoryService.save(new ProductCategory("final", 4));
        Assert.assertEquals("final",result.getCategoryName());
    }

}