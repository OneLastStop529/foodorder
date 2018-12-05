package top.onelaststop.foodorder.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import top.onelaststop.foodorder.dataobject.ProductInfo;
import top.onelaststop.foodorder.enums.ProductStatusEnum;
import top.onelaststop.foodorder.service.ProductService;


import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    ProductService productService;


    @Test
    public void findOne() {
        ProductInfo productInfo = productService.findOne("123456");
        Assert.assertEquals("123456", productInfo.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> upAll = productService.findUpAll();
        Assert.assertNotNull(upAll);
    }

    @Test
    public void findAll() {
        PageRequest pageRequest = new PageRequest(0, 2);
        Page<ProductInfo> page = productService.findAll(pageRequest);

        Assert.assertNotEquals(0,page.getTotalElements());

    }
    

    @Test
    @Transactional
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductName("饮料");
        productInfo.setProductId("333444");
        productInfo.setProductPrice(BigDecimal.valueOf(9.9));
        productInfo.setCategoryType(6);
        productInfo.setProductDescription("从饮料机里出来的酸甜");
        productInfo.setProductIcon("http://xhjkshw.jpg");
        productInfo.setProductStatus(0);
        productInfo.setProductStock(100);

        ProductInfo save = productService.save(productInfo);

        Assert.assertEquals(save,productService.findOne("333444"));
    }

    @Test
    public void increaseStock() {
    }

    @Test
    public void decreaseStock() {
    }

    @Test
    public void onSale() {
        ProductInfo result = productService.onSale("123456");
        Assert.assertEquals(ProductStatusEnum.UP.getCode(),result.getProductStatus().getCode());
    }

    @Test
    public void offSale() {
        ProductInfo result = productService.offSale("123456");
        Assert.assertEquals(ProductStatusEnum.DOWN.getCode(),result.getProductStatus().getCode());
    }
}