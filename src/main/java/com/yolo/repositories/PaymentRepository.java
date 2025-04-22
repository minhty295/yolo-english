package com.yolo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yolo.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
