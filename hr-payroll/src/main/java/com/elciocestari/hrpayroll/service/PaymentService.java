package com.elciocestari.hrpayroll.service;

import org.springframework.stereotype.Service;

import com.elciocestari.hrpayroll.entities.Payment;

@Service
public class PaymentService {
	
	public Payment getPayment(Long workerId, int days) {
		
		return new Payment("Bob", 200.00, days);
	}
}
