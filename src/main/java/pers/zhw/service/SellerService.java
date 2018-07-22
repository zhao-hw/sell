package pers.zhw.service;

import pers.zhw.dataobject.SellerInfo;

public interface SellerService {
    SellerInfo findSellerInfoByOpenid(String openid);
    SellerInfo findSellerInfoByUsername(String username);
}
