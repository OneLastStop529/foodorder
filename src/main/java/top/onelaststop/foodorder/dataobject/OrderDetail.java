package top.onelaststop.foodorder.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
/*订单详情*/
@Data
@Entity
public class OrderDetail {
    @Id
    private String detailId;

    /*订单ID*/
    private String orderId;

    /*商品ID*/
    private String productId;

    /*商品名称*/
    private String productName;

    /*单价*/
    private BigDecimal productPrice;

    /*商品质量*/
    private Integer productQuantity;

    /*商品小图*/
    private String productIcon;


}
