package top.onelaststop.foodorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.onelaststop.foodorder.dataobject.ProductInfo;

import java.util.List;


public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {
    /**/
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
