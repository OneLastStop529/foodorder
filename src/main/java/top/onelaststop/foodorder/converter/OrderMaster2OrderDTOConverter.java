package top.onelaststop.foodorder.converter;

import org.springframework.beans.BeanUtils;
import top.onelaststop.foodorder.dataobject.OrderMaster;
import top.onelaststop.foodorder.dto.OrderDTO;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMaster2OrderDTOConverter {
    public static OrderDTO convert(OrderMaster orderMaster) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList) {
        return orderMasterList.stream()
                .map(orderMaster -> convert(orderMaster))
                .collect(Collectors.toList());

    }
}
