package top.onelaststop.foodorder.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import top.onelaststop.foodorder.dataobject.ProductInfo;
import top.onelaststop.foodorder.dto.CartDTO;

import java.util.List;

public interface ProductService {
    /*
    * 查询所有在家商品列表*/
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    void increaseStock(List<CartDTO> cartDTOList);

    ProductInfo findOne(String productId);

    void decreaseStock(List<CartDTO> cartDTOList);



    ProductInfo onSale(String productId);

    ProductInfo offSale(String productId);

}
