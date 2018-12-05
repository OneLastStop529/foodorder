package top.onelaststop.foodorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.onelaststop.foodorder.dataobject.ProductCategory;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
