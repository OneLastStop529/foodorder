package top.onelaststop.foodorder.dataobject;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import top.onelaststop.foodorder.enums.ProductStatusEnum;
import top.onelaststop.foodorder.util.EnumUtil;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



@Entity
@Data
@DynamicUpdate
/*商品信息类*/
public class ProductInfo implements Serializable {

    @Id
    /*商品ID*/
    private String productId;

    /*商品名称*/
    private String productName;

    /*商品价格*/
    private BigDecimal productPrice;

    /*商品库存*/
    private Integer productStock;

    /*商品描述*/
    private String productDescription;

    /*商品小图*/
    private String productIcon;

    /*商品状态*/
    private Integer productStatus = ProductStatusEnum.UP.getCode();

    /*类目编号*/
    private Integer categoryType;


    /*创建时间*/
    private Date createTime;

    /*更新时间*/
    private Date updateTime;


    @JsonIgnore
    public ProductStatusEnum getProductStatus() {
        return EnumUtil.getByCode(productStatus,ProductStatusEnum.class);
    }
}
