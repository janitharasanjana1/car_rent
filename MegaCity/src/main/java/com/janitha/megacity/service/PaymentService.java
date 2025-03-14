package com.janitha.megacity.service;



import com.janitha.megacity.entity.Payment;

import java.util.List;

public interface PaymentService {
    void processPayment(Payment payment);
    Payment getPaymentById(int id);
    List<Payment> getAllPayments();
    void updatePaymentStatus(int paymentId, String status);
    void deletePayment(int id);
}
