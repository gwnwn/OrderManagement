package com.example.ecommerce.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/order")

public class OrdersController {

    private final OrdersService ordersService;

    @Autowired
    public OrdersController (OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping
    public List<Orders> getOrder() {
        return ordersService.getOrders();
    }

    @PostMapping
    public void placeNewOrder(@RequestBody Orders orders) {
        ordersService.placeNewOrder(orders);
    }

    //http://localhost:8080/order/1?paymentStatus=false&orderStatus=false
    @PutMapping("/{order_id}")
    public void updatePaymentStatus(@PathVariable Long order_id,
                                    @RequestParam(required = false) Boolean paymentStatus,
                                    @RequestParam(required = false) Boolean orderStatus) {
        ordersService.updatePaymentStatus(order_id, paymentStatus,orderStatus);
    }

    @DeleteMapping("/{order_id}")
    public void deleteOrder(@PathVariable Long order_id) {
        ordersService.deleteOrder(order_id);
    }
}
