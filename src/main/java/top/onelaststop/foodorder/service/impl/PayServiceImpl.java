package top.onelaststop.foodorder.service.impl;

import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.service.BestPayService;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.onelaststop.foodorder.dataobject.PaySaPi;
import top.onelaststop.foodorder.dto.OrderDTO;
import top.onelaststop.foodorder.service.OrderService;
import top.onelaststop.foodorder.service.PayService;
import top.onelaststop.foodorder.util.paysapi.PayUtil;


@Service
public class PayServiceImpl implements PayService  {

    @Autowired
    private BestPayService bestPayService;


    private OrderService orderService;

    @Override
    public PaySaPi create(OrderDTO orderDTO) {
        PaySaPi paySaPi = new PaySaPi();
        paySaPi.setOrderid(orderDTO.getOrderId());
        paySaPi.setPrice(orderDTO.getOrderAmount().floatValue());
//        paySaPi.setKey(PayUtil.getKey());


        return paySaPi;
    }
}
