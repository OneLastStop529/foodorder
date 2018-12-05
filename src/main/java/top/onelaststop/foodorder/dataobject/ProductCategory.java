package top.onelaststop.foodorder.dataobject;


import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@DynamicUpdate
@Data
/*商品类目*/
public class ProductCategory {

    @Id
    @GeneratedValue
    /*类目ID*/
    private Integer categoryId;

    /*类目名称*/
    private String categoryName;

    /*类目类别*/
    private Integer categoryType;

    /*创建时间*/
    private Date createTime;

    /*更新时间*/
    private Date updateTime;

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    public ProductCategory() {
    }
}
