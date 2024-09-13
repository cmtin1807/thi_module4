package com.thi_module4.service.orderProduct;


import com.thi_module4.model.OrderProduct;
import com.thi_module4.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderProductService implements IOrderProductService {
    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public Iterable<OrderProduct> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void save(OrderProduct orderProduct) {
        orderRepository.save(orderProduct);
    }

    @Override
    public Optional<OrderProduct> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Page<OrderProduct> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }
}
