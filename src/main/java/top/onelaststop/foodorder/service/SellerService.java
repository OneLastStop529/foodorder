package top.onelaststop.foodorder.service;

import top.onelaststop.foodorder.dataobject.SellerInfo;

public interface SellerService {

    public SellerInfo findSellerServiceByOpenid(String openid);
}
