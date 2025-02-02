package com.damian.spring_boot_eshop.service;

import com.damian.spring_boot_eshop.dao.CustomerRepository;
import com.damian.spring_boot_eshop.dto.Purchase;
import com.damian.spring_boot_eshop.dto.PurchaseResponse;
import com.damian.spring_boot_eshop.entity.Customer;
import com.damian.spring_boot_eshop.entity.Order;
import com.damian.spring_boot_eshop.entity.OrderItem;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        Order order = purchase.getOrder();

        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(order::add);

        order.setShippingAddress(purchase.getShippingAddress());

        Customer customer = purchase.getCustomer();
        customer.add(order);

        customerRepository.save(customer);

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
