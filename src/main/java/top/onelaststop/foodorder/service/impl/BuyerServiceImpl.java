package top.onelaststop.foodorder.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.onelaststop.foodorder.dto.OrderDTO;
import top.onelaststop.foodorder.enums.ResultEnum;
import top.onelaststop.foodorder.exception.SellException;
import top.onelaststop.foodorder.service.BuyerService;
import top.onelaststop.foodorder.service.OrderService;

@Slf4j
/*卖家端服务层实现*/
@Service
public class  BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOne(String openid, String orderId) {
        return checkOrderOwner(openid, orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {


        OrderDTO orderDTO = checkOrderOwner(openid, orderId);
        if (orderDTO == null) {
            log.error("取消订单 查不到该订单, orderId={}",orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);

    }

    private OrderDTO checkOrderOwner(String openid, String orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
        return null;
        }

        if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)) {
            log.error("##查询订单## 订单的openid不一致, openid={}, orderDTO={}", openid, orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }

        return orderDTO;
    }
}
