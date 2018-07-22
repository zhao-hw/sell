package pers.zhw.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import pers.zhw.constant.RedisConstant;
import pers.zhw.dataobject.SellerInfo;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerServiceImplTest {

    private static final String openid = "aaccvv";

    @Autowired
    private SellerServiceImpl sellerService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void findSellerInfoByOpenid() throws Exception {
        SellerInfo result = sellerService.findSellerInfoByOpenid(openid);
        Assert.assertEquals(openid,result.getOpenid());
    }

    @Test
    public void sss() throws Exception {
        System.out.println(redisTemplate.opsForValue().get(RedisConstant.TOKEN_PREFIX+"6ed861c6-0831-4eb5-94f8-a2de66af989c"));
    }

}