package top.onelaststop.foodorder.service;

import top.onelaststop.foodorder.dataobject.ProductCategory;

import java.util.List;

public interface CategoryService{
    /*查询商品类目*/
    ProductCategory findOne(Integer categoryId);

    /*查询所有商品*/
    List<ProductCategory> findAll();

    /*查询类目*/
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    /*保存*/
    ProductCategory save(ProductCategory productCategory);
}
