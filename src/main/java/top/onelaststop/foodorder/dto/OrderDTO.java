package top.onelaststop.foodorder.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import top.onelaststop.foodorder.dataobject.OrderDetail;
import top.onelaststop.foodorder.enums.OrderStatusEnum;
import top.onelaststop.foodorder.enums.PayStatusEnum;
import top.onelaststop.foodorder.util.EnumUtil;
import top.onelaststop.foodorder.util.serializer.Date2LongSerializer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Data
/*订单数据访问对象*/
public class OrderDTO {


    /*订单ID*/
    private String  orderId;

    /*买家姓名*/
    private String  buyerName;

    /*买家手机号*/
    private String buyerPhone;

    /*买家地址*/
    private String buyerAddress;

    /*买家OpenID*/
    private String buyerOpenid;

    /*订单数量*/
    private BigDecimal orderAmount;

    /*订单状态*/
    private Integer orderStatus;

    /*支付状态*/
    private Integer payStatus;

    @JsonSerialize(using = Date2LongSerializer.class)
    /*创建时间*/
    private Date createTime;

    @JsonSerialize(using = Date2LongSerializer.class)
    /*更新时间*/
    private Date updateTime;

    /*订单详情列表*/
    List<OrderDetail> orderDetailList;

    @JsonIgnore
    /*获取订单状态*/
    public PayStatusEnum getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }


    @JsonIgnore
    /*获取支付状态*/
    public OrderStatusEnum getOrderStatusEnum(){
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }


}
