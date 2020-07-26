package com.orderItems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.orderItems.model.OrderItem;
import com.orderItems.repository.OrderItemsRepository;

@Service
public class OrderItemsService {

	@Autowired
	private OrderItemsRepository repository;

	public List<OrderItem> getOrderItemsByOrderId(@PathVariable Integer id) {
		return repository.getOrderItemsByOrderItems(id);
	}

	public List<OrderItem> getAll() {
		return (List<OrderItem>) repository.findAll();
	}

	public List<OrderItem> saveOrderItems(List<OrderItem> orderItems) {
		return (List<OrderItem>) repository.saveAll(orderItems);
	}

	public OrderItem saveOrderItem(OrderItem orderItem) {
		return repository.save(orderItem);
	}

	public List<OrderItem> getOrderItemByProductCode(String productCode) {
		return repository.getOrderItemsByProductCode(productCode);
	}

}
