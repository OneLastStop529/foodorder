package top.onelaststop.foodorder.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.onelaststop.foodorder.dataobject.ProductInfo;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("香辣鸡翅");
        productInfo.setProductPrice(BigDecimal.valueOf(9.9));
        productInfo.setCategoryType(2);
        productInfo.setProductDescription("经典的辣翅，经典的味道");
        productInfo.setProductIcon("http://xhjkshw.jpg");
        productInfo.setProductStatus(0);
        productInfo.setProductStock(100);

        productInfoRepository.save(productInfo);

    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> productInfoList = productInfoRepository.findByProductStatus(0);
        Assert.assertNotEquals(0,productInfoList.size());

    }
}