package top.onelaststop.foodorder.enums;


import lombok.Getter;

import java.util.DuplicateFormatFlagsException;

@Getter
public enum ResultEnum {
     ORDER_UPDATE_FAIL(15,"订单更新失败"),

    ORDER_DETAIL_EMPTY(16,"订单详情为空"),

     OUT_OF_STOCK(18,"库存不足"),

    ORDER_OWNER_ERROR(19,"该订单不属于当前用户"),
    ORDERDETAIL_NOT_EXIST(13,"订单详情不存在"),
    PRODUCT_NOT_EXIST(1,"商品不存在"),
    ORDER_NOT_EXIST(2,"订单不存在"),
     ORDER_STATUS_ERROR(3,"订单状态错误") ,
     ORDER_PAY_STATUS_ERROR(4,"支付状态错误"),
    PARAM_ERROR(5,"参数错误"),
     CART_EMPTY(6,"购物车为空"),
     WECHAT_MP_ERROR(7,"微信开放错误"),
     ORDER_CANCEL_SUCCESS (8,"订单取消成功") ,
     ORDER_FINISH_SUCCESS(9,"订单完结成功"),
     PRODUCT_STATUS_ERROR (10,"商品状态错误");
    ;


    private Integer code;

     private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
