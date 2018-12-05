package top.onelaststop.foodorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.onelaststop.foodorder.dataobject.SellerInfo;

public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {
    SellerInfo findByOpenid(String openId);
}

