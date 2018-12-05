package top.onelaststop.foodorder.service;


import top.onelaststop.foodorder.dto.OrderDTO;

/*买家端服务层*/
public interface BuyerService {

    /*查询订单*/
    OrderDTO findOne(String openid, String orderId);

    /*取消订单*/
    OrderDTO cancelOrder(String openid, String ordrId);

}
