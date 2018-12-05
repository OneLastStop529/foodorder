package top.onelaststop.foodorder.service;

import com.lly835.bestpay.model.PayResponse;
import top.onelaststop.foodorder.dataobject.PaySaPi;
import top.onelaststop.foodorder.dto.OrderDTO;
import top.onelaststop.foodorder.util.paysapi.PayUtil;

public interface PayService {
//todo payservice implementation
public PaySaPi create(OrderDTO orderDTO);


}
