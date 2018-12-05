package top.onelaststop.foodorder.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.onelaststop.foodorder.dataobject.ProductCategory;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Test
    public void findOneTest(){
        ProductCategory productCategory = productCategoryRepository.findOne(1);
        System.out.println(productCategory.toString());
    }

    @Test
    public void saveTest(){
        ProductCategory productCategory1 = new ProductCategory("热销榜", 1);
        ProductCategory result = productCategoryRepository.save(productCategory1);
        Assert.assertNotNull(result);
    }

    @Test
    public void saveBunch() {

        ProductCategory productCategory = new ProductCategory("主食", 2);
        ProductCategory productCategory2 = new ProductCategory("小食", 3);
        ProductCategory productCategory3 = new ProductCategory("饮料", 4);
        ProductCategory productCategory4 = new ProductCategory("甜点", 5);
        ProductCategory productCategory5 = new ProductCategory("套餐", 6);

        List<ProductCategory> productCategories = new ArrayList<>();
        productCategories.add(productCategory);
        productCategories.add(productCategory2);
        productCategories.add(productCategory3);
        productCategories.add(productCategory4);
        productCategories.add(productCategory5);
        List<ProductCategory> save = productCategoryRepository.save(productCategories);
        Assert.assertNotNull(save);
    }
}