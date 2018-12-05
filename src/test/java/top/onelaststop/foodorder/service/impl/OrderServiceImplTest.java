package top.onelaststop.foodorder.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import top.onelaststop.foodorder.dataobject.OrderDetail;
import top.onelaststop.foodorder.dto.OrderDTO;
import top.onelaststop.foodorder.enums.OrderStatusEnum;
import top.onelaststop.foodorder.enums.PayStatusEnum;
import top.onelaststop.foodorder.service.OrderService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceImplTest {
    private  final String ORDER_ID = "1523439045030554895";
    private final String BUYER_OPENID = "1523436563956421224";

    @Autowired
    private OrderService orderService;

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("陈咬春");
        orderDTO.setBuyerAddress("瘫痪传世");
        orderDTO.setBuyerPhone("74174174171");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail order1 = new OrderDetail();
        order1.setProductId("123456");
        order1.setProductQuantity(2);

        OrderDetail order2 = new OrderDetail();
        order2.setProductId("333444");
        order2.setProductQuantity(2);

        orderDetailList.add(order1);
        orderDetailList.add(order2);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        log.info("【创建订单】 result= {}", result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() {
        OrderDTO result = orderService.findOne(ORDER_ID);
        log.info("[[查询单个订单]] result= {}", result);
        Assert.assertEquals(ORDER_ID,result.getOrderId());

    }


    @Test
    public void findList() {
        PageRequest request = new PageRequest(0, 2);
        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID, request);
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());

    }

    @Test
    public void cancel(){
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCELLED.getCode(),result.getOrderStatus());
    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),result.getOrderStatus());

    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),result.getPayStatus());

    }
}