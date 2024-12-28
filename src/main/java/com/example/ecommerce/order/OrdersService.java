package com.example.ecommerce.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrdersService {
    private final OrdersRepository ordersRepository;
    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Autowired
    public List<Orders> getOrders() {
        return ordersRepository.findAll();
    }

    public void placeNewOrder(Orders orders) {
        System.out.println(orders);
        ordersRepository.save(orders);
    }

    @Transactional
    public void updatePaymentStatus(Long orderId, Boolean paymentStatus, Boolean orderStatus) {
        Orders ord = ordersRepository.findById(orderId)
                .orElseThrow(()->new IllegalStateException("Order with id " + orderId + " does not exist"));
        if (paymentStatus != null) {
            ord.setPaymentStatus(paymentStatus);
        }
        if (orderStatus != null) {
            ord.setOrderStatus(orderStatus);
        }
        ordersRepository.save(ord);
    }

    public void deleteOrder(Long orderId) {
        ordersRepository.findById(orderId)
                .orElseThrow(()->new IllegalStateException("Order with id " + orderId + " does not exist"));
        ordersRepository.deleteById(orderId);

    }
}
