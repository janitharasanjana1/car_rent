package com.janitha.megacity.dao;





import com.janitha.megacity.entity.Payment;

import java.util.List;

public interface PaymentDAO {
    void createPayment(Payment payment);
    Payment getPaymentById(int id);
    List<Payment> getAllPayments();
    void updatePayment(Payment payment);
    void deletePayment(int id);
}
