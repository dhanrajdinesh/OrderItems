package com.orderItems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.orderItems.model.OrderItem;
import com.orderItems.service.OrderItemsService;

@RestController
public class OrderItemsController {

	@Autowired
	private OrderItemsService service;

	@GetMapping("/orderItem/{productCode}")
	public List<OrderItem> getOrderItemByProductId(@PathVariable String productCode) {
		return service.getOrderItemByProductCode(productCode);
	}

	@GetMapping("/orderItems/orderId/{orderId}")
	public List<OrderItem> getOrderItemsByOrderId(@PathVariable Integer orderId) {
		return service.getOrderItemsByOrderId(orderId);
	}

	@GetMapping("/orderItems")
	public List<OrderItem> getOrderItems() {
		return service.getAll();
	}

	@PostMapping(value = "/orderItems", produces =

	{ "application/json; charset=UTF-8" })

	@ResponseStatus(HttpStatus.CREATED)
	public List<OrderItem> saveOrderItems(@RequestBody List<OrderItem> orderItems) {
		return service.saveOrderItems(orderItems);
	}

	@PostMapping("/orderItem")
	@ResponseStatus(HttpStatus.CREATED)
	public OrderItem saveOrderItem(@RequestBody OrderItem orderItem) {
		return service.saveOrderItem(orderItem);
	}
}
