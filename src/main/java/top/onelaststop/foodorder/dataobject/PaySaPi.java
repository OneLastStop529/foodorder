package top.onelaststop.foodorder.dataobject;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaySaPi {

    private String paysapi_id;

    /**
     * 您的自定义订单号
     */
    private String orderid;

    /**
     * 订单定价
     */
    private Float price;

    /**
     * 实际支付金额
     */
    private String realprice;

    /**
     * 您的自定义用户ID
     */
    private String orderuid;

    /**
     * 秘钥
     */
    private String key;


}
