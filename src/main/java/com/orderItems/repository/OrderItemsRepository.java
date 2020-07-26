package com.orderItems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.orderItems.model.OrderItem;
import com.orderItems.model.ProductId;

public interface OrderItemsRepository extends CrudRepository<OrderItem, ProductId> {

	@Query(value = "select * from ORDER_ITEMS oi where oi.order_id =:orderId", nativeQuery = true)
	List<OrderItem> getOrderItemsByOrderItems(@Param("orderId") Integer orderId);

	@Query(value = "select * from ORDER_ITEMS oi where oi.product_code =:productCode", nativeQuery = true)
	List<OrderItem> getOrderItemsByProductCode(@Param("productCode") String productCode);

}
