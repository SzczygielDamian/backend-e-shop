package com.damian.spring_boot_eshop.dto;

import com.damian.spring_boot_eshop.entity.Address;
import com.damian.spring_boot_eshop.entity.Customer;
import com.damian.spring_boot_eshop.entity.Order;
import com.damian.spring_boot_eshop.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
