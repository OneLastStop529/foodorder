package top.onelaststop.foodorder.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.onelaststop.foodorder.VO.ProductInfoVO;
import top.onelaststop.foodorder.VO.ProductVO;
import top.onelaststop.foodorder.VO.ResultVO;
import top.onelaststop.foodorder.dataobject.ProductCategory;
import top.onelaststop.foodorder.dataobject.ProductInfo;
import top.onelaststop.foodorder.service.CategoryService;
import top.onelaststop.foodorder.service.ProductService;
import top.onelaststop.foodorder.util.ResultVOUtil;


import javax.persistence.Cacheable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list(
//            @RequestParam("sellerid") String sellerid
    ) {
//        查询所有上架的商品
        List<ProductInfo> productInfoList = productService.findUpAll();
//                查询类目
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());

        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
//数据拼装：外层商品类目
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory :
                productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());
//内层 商品详情
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo: productInfoList
                 ) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }


}
