package top.onelaststop.foodorder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import top.onelaststop.foodorder.dataobject.ProductInfo;
import top.onelaststop.foodorder.dto.CartDTO;
import top.onelaststop.foodorder.enums.ProductStatusEnum;
import top.onelaststop.foodorder.enums.ResultEnum;
import top.onelaststop.foodorder.exception.SellException;
import top.onelaststop.foodorder.repository.ProductInfoRepository;
import top.onelaststop.foodorder.service.ProductService;

import java.util.List;

@Service
public class  ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRepository productInfoRepository;


    @Override
    public ProductInfo findOne(String productId) {
        return productInfoRepository
                .findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository
                .findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoRepository
                .findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoRepository
                .save(productInfo);
    }

    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {

        for (CartDTO cartDTO
                : cartDTOList) {
            ProductInfo productInfo = productInfoRepository
                    .findOne(cartDTO.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock()
                    + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);

            productInfoRepository.save(productInfo);
        }



    }

    @Override
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO
                :cartDTOList) {
            ProductInfo productInfo = productInfoRepository.findOne(cartDTO.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0) {
                throw new SellException(ResultEnum.OUT_OF_STOCK);
            }
            productInfo.setProductStock(result);

            productInfoRepository.save(productInfo);
        }
    }


    @Override
    public ProductInfo onSale(String productId) {
        ProductInfo productInfo = productInfoRepository.findOne(productId);
        if (productInfo == null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if(productInfo.getProductStatus() == ProductStatusEnum.UP){
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }

        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());

        return productInfoRepository.save(productInfo);
    }

    @Override
    public ProductInfo offSale(String productId) {
        ProductInfo productInfo = productInfoRepository.findOne(productId);
        if (productInfo == null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if(productInfo.getProductStatus() == ProductStatusEnum.DOWN){
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }

        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());

        return productInfoRepository.save(productInfo);
    }
}
