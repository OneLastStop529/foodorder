package top.onelaststop.foodorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.onelaststop.foodorder.dataobject.OrderDetail;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    List<OrderDetail> findByOrderId(String orderId);

}
