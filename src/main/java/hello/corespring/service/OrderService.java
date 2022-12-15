package hello.corespring.service;

import hello.corespring.order.Order;

public interface OrderService {
	Order createOrder(Long memberId, String itemName, int itemPrice);
}
