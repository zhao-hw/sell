package pers.zhw.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.zhw.dataobject.SellerInfo;
import pers.zhw.utils.KeyUtil;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoRepositoryTest {

    @Autowired
    SellerInfoRepository repository;
    @Test
    public void save(){
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setId(KeyUtil.getUniqueKey());
        sellerInfo.setOpenid("aaccvv");
        sellerInfo.setUsername("admin");
        sellerInfo.setPassword("admin");
        SellerInfo result = repository.save(sellerInfo);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByOpenid() throws Exception {
        SellerInfo result = repository.findByOpenid("aaccvv");
        Assert.assertEquals("admin",result.getUsername());
    }
}