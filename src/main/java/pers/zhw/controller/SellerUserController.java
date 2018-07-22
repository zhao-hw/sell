package pers.zhw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pers.zhw.config.ProjectUrlConfig;
import pers.zhw.constant.CookieConstant;
import pers.zhw.constant.RedisConstant;
import pers.zhw.dataobject.SellerInfo;
import pers.zhw.enums.ResultEnum;
import pers.zhw.service.impl.SellerServiceImpl;
import pers.zhw.utils.CookieUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/seller")
public class SellerUserController {

    @Autowired
    private SellerServiceImpl sellerService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    @RequestMapping(value = "/login")
    public ModelAndView login(String username,
                              String password,
                              Map<String,Object> map,
                              HttpServletResponse response){
        SellerInfo sellerInfo = sellerService.findSellerInfoByUsername(username);
        if (sellerInfo == null || !username.equals(sellerInfo.getUsername()) || !password.equals(sellerInfo.getPassword())){
            if (username == null){
                map.put("msg"," ");
            } else {
                map.put("msg", ResultEnum.LOGIN_FAIL.getMsg());
            }
            return new ModelAndView("common/login",map);
        }
        //设置token到redis
        String token = UUID.randomUUID().toString();
        Integer expire = RedisConstant.EXPIRE;
        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX,token),username,expire, TimeUnit.SECONDS);
        //设置token到cookie
        CookieUtil.set(response, CookieConstant.TOKEN,token,expire);
        return new ModelAndView("redirect:"+projectUrlConfig.getSell()+"/sell/seller/order/list");
    }

    @RequestMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,
                       HttpServletResponse response,
                       Map<String,Object> map) {
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie != null){
            redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
            CookieUtil.set(response,CookieConstant.TOKEN,null,0);
        }
        map.put("msg",ResultEnum.LOGOUT_SUCCESS.getMsg());
        map.put("url","/sell/seller/login");
        return new ModelAndView("common/suces",map);
    }
}
