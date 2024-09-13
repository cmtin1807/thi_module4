package com.thi_module4.repository;

import com.thi_module4.model.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<OrderProduct, Long> {
}
