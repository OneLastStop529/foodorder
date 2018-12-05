package top.onelaststop.foodorder.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import top.onelaststop.foodorder.enums.OrderStatusEnum;
import top.onelaststop.foodorder.enums.PayStatusEnum;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/*订单主页*/
@Entity
@Data
@DynamicUpdate
public class OrderMaster {
   @Id
   /*订单ID*/
   private String orderId;

   /*买家姓名 */
   private String buyerName;

   /*买家手机号*/
   private String buyerPhone;

   /*买家地址*/
   private String buyerAddress;

   /*买家OpenID*/
   private String buyerOpenid;

   /*订单数量*/
   private BigDecimal orderAmount;

   /*订单状态 ，默认为新订单*/
   private Integer orderStatus = OrderStatusEnum.NEW.getCode();

   /*支付状态，默认为等待*/
   private Integer payStatus = PayStatusEnum.WAIT.getCode();

   /*创造时间*/
   private Date createTime;

   /*更新时间*/
   private Date updateTime;





}
