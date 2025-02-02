package com.damian.spring_boot_eshop.service;

import com.damian.spring_boot_eshop.dto.Purchase;
import com.damian.spring_boot_eshop.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
