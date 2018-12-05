package top.onelaststop.foodorder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.onelaststop.foodorder.dataobject.SellerInfo;
import top.onelaststop.foodorder.repository.SellerInfoRepository;
import top.onelaststop.foodorder.service.SellerService;

@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    SellerInfoRepository sellerInfoRepository;



    @Override
    public SellerInfo findSellerServiceByOpenid(String openid) {
        return sellerInfoRepository.findByOpenid(openid);
    }
}
